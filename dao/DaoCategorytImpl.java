package ma.enset.app.dao;

import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DaoCategorytImpl implements DaoCategory {

    @Override
    public List<Category> findAll() {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from CATEGORY");
            return getCategories(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    private List<Category> getCategories(PreparedStatement stm) throws SQLException {
        ResultSet rs = stm.executeQuery();
        List<Category> listCategory = new ArrayList<>();
        while(rs.next()){
            Category c = new Category();
            c.setId(rs.getInt("ID"));
            c.setName(rs.getString("NAME"));
            listCategory.add(c);
        }
        return listCategory;
    }

    @Override
    public Category findById(int id) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from PRODUITS where ID = ?");
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            Category c = new Category();
            if(rs.next()){
                c.setId(rs.getInt("ID"));
                c.setName(rs.getString("Name"));
                return c;
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
    public Category save(Category c) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("insert into CATEGORY(NOM)" +
                    "values (?)");
            stm.setString(1, c.getName());
            stm.executeUpdate();
            return c;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean delete(Category o) {
        try {
            Connection connection = SingletonConnexionDB.getConnection();
            PreparedStatement stm = connection.prepareStatement("delete from PRODUITS where ID = ?");
            stm.setLong(1, o.getId());
            stm.executeUpdate();
        } catch (SQLException e) {
            return false;
        }
        return true;
    }

    @Override
    public Category update(Category c) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("update CATEGORY set NOM = ? where ID = ?");
            stm.setString(1, c.getName());
            stm.setLong(2, c.getId());
            stm.executeUpdate();
            return c;
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Category> getCategoryByQuery(String query) {
        Connection connection = SingletonConnexionDB.getConnection();
        try{
            PreparedStatement stm = connection.prepareStatement("select * from CATEGORY where NOM like ?");
            stm.setString(1, "%" + query + "%");
            return getCategories(stm);
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return null;
    }
}
