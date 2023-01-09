package ma.enset.app.services;

import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.util.*;

public interface ServiceCatalogue {
    List<Product> getAllProducts();
    void addProduct(Product p);
    void deleteProduct(Product p);
    List<Product> getProductByQuery(String query);
    void updateProduct(Product p);
    List<Category> getAllCategories();
    void addCategory(Category c);
    void deleteCategory(Category c);
}
