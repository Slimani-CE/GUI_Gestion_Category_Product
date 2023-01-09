package ma.enset.app.dao;

import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.util.List;

public interface DaoCategory extends Dao<Category>{
    List<Category> getCategoryByQuery(String query);
}
