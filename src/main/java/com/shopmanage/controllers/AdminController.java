package com.shopmanage.controllers;

import com.shopmanage.dao.ProductDAO;
import com.shopmanage.models.Product;
import com.shopmanage.services.ProductService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class AdminController {

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Double> colPrice;

    @FXML
    private TableColumn<Product, Integer> colStock;

    @FXML
    private TextField nameField;

    @FXML
    private TextField priceField;

    @FXML
    private TextField stockField;

    private final ProductService productService = new ProductService(new ProductDAO());
    private final ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Correction des colonnes
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrice()).asObject());
        colStock.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getStock()).asObject());

        loadProducts();
    }

    private void loadProducts() {
        productList.setAll(productService.getAllProducts());
        productTable.setItems(productList);
    }

    @FXML
    private void addProduct() {
        try {
            String name = nameField.getText();
            double price = Double.parseDouble(priceField.getText());
            int stock = Integer.parseInt(stockField.getText());

            productService.addProduct(name, price, stock);
            loadProducts();

            nameField.clear();
            priceField.clear();
            stockField.clear();

        } catch (Exception e) {
            showAlert("Erreur", "Vérifiez les données saisies.");
        }
    }

    @FXML
    private void logout() {
        try {
            Stage stage = (Stage) productTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            showAlert("Erreur", "Impossible de se déconnecter.");
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}
