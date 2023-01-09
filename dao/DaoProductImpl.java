package ma.enset.app.dao;

import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class DaoProductImpl implements DaoProduct {

    @Override
    public List<Product> findAll() {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS");
            return getProduits(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Product> getProduits(PreparedStatement stm) throws SQLException {
        ResultSet rs = stm.executeQuery();
        List<Product> listProduit = new ArrayList<>();
        Connection connection = SingletonConnexionDB.getConnection();
        while(rs.next()){
            Product p = new Product();
            p.setId(rs.getInt("ID"));
            p.setNom(rs.getString("NOM"));
            p.setDescreption(rs.getString("DESCREPTION"));
            p.setPrix(rs.getFloat("PRIX"));
            p.setQuantite(rs.getInt("QUANTITE"));

            PreparedStatement pstm1 = connection.prepareStatement("select * from CATEGORY where ID = ?");
            pstm1.setLong(1, rs.getLong("ID_Category"));
            ResultSet rs1 = pstm1.executeQuery();
            Category c = new Category();
            if(rs1.next()){
                c.setId(rs1.getInt("ID"));
                c.setName(rs1.getString("Name"));
                p.setCategory(c);
            }
            listProduit.add(p);
        }
        return listProduit;
    }

    @Override
    public Product findById(int id) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS where ID = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Product p = new Product();
            if(rs.next()){
                p.setId(rs.getInt("ID"));
                p.setNom(rs.getString("NOM"));
                p.setDescreption(rs.getString("DESCREPTION"));
                p.setPrix(rs.getFloat("PRIX"));
                p.setQuantite(rs.getInt("QUANTITE"));

                return p;
            }
            else{
                return null;
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product save(Product p) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("insert into PRODUITS(NOM, DESCREPTION, PRIX, QUANTITE, ID_CATEGORY)" +
                    "values (?, ?, ?, ?, ?)");
            stm.setString(1,p.getNom());
            stm.setString(2,p.getDescreption());
            stm.setFloat(3,p.getPrix());
            stm.setInt(4,p.getQuantite());
            stm.setLong(5,p.getCategory().getId());
            stm.executeUpdate();
            return p;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Product o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from PRODUITS where ID = ?");
            stm.setInt(1, o.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Product update(Product o) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("update PRODUITS set NOM = ?, DESCREPTION = ?, PRIX = ?, QUANTITE = ? where ID = ?");
            stm.setString(1, o.getNom());
            stm.setString(2, o.getDescreption());
            stm.setFloat(3, o.getPrix());
            stm.setInt(4, o.getQuantite());
            stm.setInt(5, o.getId());
            stm.executeUpdate();
            return o;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Product> getProduitByQuery(String query) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS where NOM like ? or DESCREPTION LIKE ?");
            stm.setString(1, "%" + query + "%");
            stm.setString(2, "%" + query + "%");
            return getProduits(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
