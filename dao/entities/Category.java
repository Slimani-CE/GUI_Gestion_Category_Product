package ma.enset.app.dao.entities;

import com.sun.scenario.effect.impl.prism.PrDrawable;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private long id;
    private String name;
    private List<Product> listProduct = new ArrayList<>();

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }
    public void addProduct(Product p){
        this.listProduct.add(p);
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
