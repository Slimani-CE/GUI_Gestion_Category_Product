package ma.enset.app.dao;

import ma.enset.app.dao.entities.Product;

import java.util.*;

public interface DaoProduct extends Dao<Product>{
    List<Product> getProduitByQuery(String query);
}
