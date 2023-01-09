package ma.enset.app.dao.entities;
import java.io.Serializable;

//  Classe persistante ou entité
public class Product implements Serializable {
    private int id;
    private String nom;
    private String descreption;
    private float prix;
    private int quantite;
    private Category category;
    public Product() {
    }
    public Product(String nom, String descreption, float prix, int quantite) {
        this.nom = nom;
        this.descreption = descreption;
        this.prix = prix;
        this.quantite = quantite;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getDescreption() {
        return descreption;
    }
    public void setDescreption(String descreption) {
        this.descreption = descreption;
    }
    public float getPrix() {
        return prix;
    }
    public void setPrix(float prix) {
        this.prix = prix;
    }
    public int getQuantite() {
        return quantite;
    }
    public void setQuantite(int quantite) {
        this.quantite = quantite;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", descreption='" + descreption + '\'' +
                ", prix=" + prix +
                ", quantite=" + quantite +
                '}';
    }
}
