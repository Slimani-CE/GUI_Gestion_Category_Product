package ma.enset.app.presentation.controllers;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import ma.enset.app.dao.DaoCategorytImpl;
import ma.enset.app.dao.DaoProductImpl;
import ma.enset.app.dao.entities.Category;
import ma.enset.app.services.ServiceCatalogue;
import ma.enset.app.services.ServiceCatalogueImpl;

import java.net.URL;
import java.util.ResourceBundle;

public class CategoryController implements Initializable {

    @FXML
    private Button ajouteBtn;
    @FXML
    private Button supprimerBtn;
    @FXML
    private TableColumn<Category, Long> idCol;
    @FXML
    private TableColumn<Category, String> nomCol;
    @FXML
    private TableView<Category> tableView;
    private ObservableList<Category> categories = FXCollections.observableArrayList();
    private ServiceCatalogue serviceCatalogue = new ServiceCatalogueImpl(new DaoProductImpl(), new DaoCategorytImpl());
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        tableView.setItems(categories);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nomCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        categories.addAll(serviceCatalogue.getAllCategories());
    }
}
