package com.shopmanage.controllers;

import com.shopmanage.dao.UserDAO;
import com.shopmanage.models.user; // classe user en minuscule
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class RegisterController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField emailField;
    @FXML private TextField fullNameField;
    @FXML private ComboBox<String> roleComboBox;
    @FXML private Button registerButton;
    @FXML private Label messageLabel;

    private final UserDAO userDAO = new UserDAO();

    @FXML
    public void initialize() {
        // Ajouter les rôles dans la ComboBox
        roleComboBox.getItems().addAll("admin", "vendeur", "user");
        roleComboBox.setValue("user"); // valeur par défaut
    }

    @FXML
    private void onRegisterClicked() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText();
        String confirmPassword = confirmPasswordField.getText();
        String email = emailField.getText().trim();
        String fullName = fullNameField.getText().trim();
        String role = roleComboBox.getValue();

        // Vérifications basiques
        if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()
                || email.isEmpty() || fullName.isEmpty() || role == null) {
            showError("Tous les champs sont obligatoires !");
            return;
        }

        if (!password.equals(confirmPassword)) {
            showError("Les mots de passe ne correspondent pas !");
            return;
        }

        if (userDAO.usernameExists(username)) {
            showError("Nom d'utilisateur déjà utilisé !");
            return;
        }

        if (userDAO.emailExists(email)) {
            showError("Email déjà utilisé !");
            return;
        }

        // Créer l'utilisateur
        user newUser = new user(username, password, email, fullName, role);
        if (userDAO.createUser(newUser)) {
            showSuccess("Utilisateur créé avec succès ! Redirection...");

            // Redirection selon le rôle
            try {
                Stage stage = (Stage) registerButton.getScene().getWindow();
                String fxmlPath;

                switch (role) {
                    case "admin":
                        fxmlPath = "/com/shopmanage/views/admin.fxml";
                        break;
                    case "vendeur":
                        fxmlPath = "/com/shopmanage/views/seller.fxml";
                        break;
                    default:
                        fxmlPath = "/com/shopmanage/views/user.fxml";
                        break;
                }

                FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlPath));
                Parent root = loader.load();

                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();

            } catch (IOException e) {
                e.printStackTrace();
                showError("Erreur lors de la redirection !");
            }
        } else {
            showError("Erreur lors de la création de l'utilisateur !");
        }
    }

    // Afficher un message d'erreur
    private void showError(String message) {
        messageLabel.setText("❌ " + message);
        messageLabel.setStyle("-fx-text-fill: #d32f2f; -fx-background-color: #ffebee; -fx-padding: 10px; -fx-background-radius: 5px;");
        messageLabel.setVisible(true);
    }

    // Afficher un message de succès
    private void showSuccess(String message) {
        messageLabel.setText("✓ " + message);
        messageLabel.setStyle("-fx-text-fill: #388e3c; -fx-background-color: #e8f5e9; -fx-padding: 10px; -fx-background-radius: 5px;");
        messageLabel.setVisible(true);
    }
}
