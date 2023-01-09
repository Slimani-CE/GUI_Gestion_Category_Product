package ma.enset.app.services;

import ma.enset.app.dao.DaoCategory;
import ma.enset.app.dao.DaoProduct;
import ma.enset.app.dao.entities.Category;
import ma.enset.app.dao.entities.Product;

import java.util.List;

public class ServiceCatalogueImpl implements ServiceCatalogue {

    DaoProduct pdao;
    DaoCategory cdao;

    public ServiceCatalogueImpl(DaoProduct pdao, DaoCategory cdao){
        this.pdao = pdao;
        this.cdao = cdao;
    }

    @Override
    public List<Product> getAllProducts() {
        return pdao.findAll();
    }

    @Override
    public void addProduct(Product p) {
        pdao.save(p);
    }

    @Override
    public void deleteProduct(Product p) {
        pdao.delete(p);
    }

    @Override
    public List<Product> getProductByQuery(String query) {
        return pdao.getProduitByQuery(query);
    }

    @Override
    public void updateProduct(Product p) {
        pdao.update(p);
    }

    @Override
    public List<Category> getAllCategories() {
        return this.cdao.findAll();
    }

    @Override
    public void addCategory(Category c) {
        this.cdao.save(c);
    }

    @Override
    public void deleteCategory(Category c) {
        this.cdao.delete(c);
    }
}
