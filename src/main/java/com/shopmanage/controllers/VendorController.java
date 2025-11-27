package com.shopmanage.controllers;

import com.shopmanage.dao.ProductDAO;
import com.shopmanage.dao.SaleDAO;
import com.shopmanage.models.Product;
import com.shopmanage.models.sale;
import com.shopmanage.services.ProductService;
import com.shopmanage.services.SaleService;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.time.LocalDateTime;

public class VendorController {

    @FXML
    private TableView<Product> productTable;

    @FXML
    private TableColumn<Product, String> colName;

    @FXML
    private TableColumn<Product, Double> colPrice;

    @FXML
    private TableColumn<Product, Integer> colStock;

    @FXML
    private Spinner<Integer> quantitySpinner;

    private final ProductService productService = new ProductService(new ProductDAO());
    private final SaleService saleService = new SaleService(new SaleDAO(), new ProductDAO());

    private final ObservableList<Product> productList = FXCollections.observableArrayList();

    @FXML
    public void initialize() {
        // Correction des colonnes
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colPrice.setCellValueFactory(cell -> new javafx.beans.property.SimpleDoubleProperty(cell.getValue().getPrice()).asObject());
        colStock.setCellValueFactory(cell -> new javafx.beans.property.SimpleIntegerProperty(cell.getValue().getStock()).asObject());

        quantitySpinner.setValueFactory(new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1));

        loadProducts();
    }

    private void loadProducts() {
        productList.setAll(productService.getAllProducts());
        productTable.setItems(productList);
    }

    @FXML
    private void confirmSale() {
        Product selected = productTable.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Erreur", "Sélectionnez un produit.");
            return;
        }

        int qty = quantitySpinner.getValue();

        if (qty > selected.getStock()) {
            showAlert("Erreur", "Stock insuffisant.");
            return;
        }

        double total = selected.getPrice() * qty;

        sale sale = new sale(selected.getId(), qty, total, LocalDateTime.now());

        saleService.addSale(sale); // enregistre la vente + met à jour le stock
        loadProducts();

        showInfo("Succès", "Vente enregistrée !");
    }

    @FXML
    private void logout() {
        try {
            Stage stage = (Stage) productTable.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/views/login.fxml"));
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }

    private void showInfo(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setHeaderText(null);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }
}
