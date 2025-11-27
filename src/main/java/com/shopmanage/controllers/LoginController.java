package com.shopmanage.controllers;

import com.shopmanage.dao.UserDAO;
import com.shopmanage.models.user;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Button loginButton;
    @FXML private Hyperlink registerLink; // lien vers l'inscription
    @FXML private Label messageLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        System.out.println("Login page loaded");
    }

    @FXML
    private void onLoginClicked() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();

        if (username.isEmpty() || password.isEmpty()) {
            showError("Tous les champs sont obligatoires");
            return;
        }

        user u = userDAO.getByUsername(username);
        if (u == null) {
            showError("Utilisateur inexistant");
            return;
        }

        if (!u.checkPassword(password)) {
            showError("Mot de passe incorrect");
            return;
        }

        showSuccess("Connexion réussie ! Redirection...");

        new Thread(() -> {
            try {
                Thread.sleep(1000);
                Platform.runLater(() -> goToDashboard(u));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    private void goToDashboard(user u) {
        try {
            Stage stage = (Stage) loginButton.getScene().getWindow();
            String fxmlPath;

            switch (u.getRole()) {
                case "admin":
                    fxmlPath = "/views/admin.fxml";
                    break;
                case "vendeur":
                    fxmlPath = "/views/seller.fxml";
                    break;
                default:
                    fxmlPath = "/views/user.fxml";
                    break;
            }

            Parent root = FXMLLoader.load(getClass().getResource(fxmlPath));
            Scene scene = new Scene(root);
            stage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
            showError("Erreur lors du chargement de la page");
        }
    }

    @FXML
    private void goToRegister() {
        try {
            Stage stage = (Stage) registerLink.getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("/views/register.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
            showError("Erreur lors du chargement de l'inscription");
        }
    }

    private void showError(String message) {
        messageLabel.setText("❌ " + message);
        messageLabel.setStyle("-fx-text-fill: #d32f2f; -fx-background-color: #ffebee; -fx-padding: 10px; -fx-background-radius: 5px;");
        messageLabel.setVisible(true);
    }

    private void showSuccess(String message) {
        messageLabel.setText("✓ " + message);
        messageLabel.setStyle("-fx-text-fill: #388e3c; -fx-background-color: #e8f5e9; -fx-padding: 10px; -fx-background-radius: 5px;");
        messageLabel.setVisible(true);
    }
}
