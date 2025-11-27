package com.shopmanage.dao;

import com.shopmanage.models.user;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.UUID;

public class UserDAO {

    // Créer un utilisateur
    public boolean createUser(user user) {
        String sql = "INSERT INTO users (username, password, email, full_name, role) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            // Hash du mot de passe
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());

            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, hashedPassword);
            pstmt.setString(3, user.getEmail());
            pstmt.setString(4, user.getFullName());
            pstmt.setString(5, user.getRole());

            pstmt.executeUpdate();
            System.out.println("Utilisateur créé : " + user.getUsername());
            return true;

        } catch (SQLException e) {
            System.err.println("Erreur création utilisateur : " + e.getMessage());
            return false;
        }
    }

    // Récupérer un utilisateur par son username
    public user getByUsername(String username) {
        String sql = "SELECT * FROM users WHERE username = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new user(
                        rs.getInt("id"),
                        rs.getString("username"),
                        rs.getString("password"),
                        rs.getString("email"),
                        rs.getString("full_name"),
                        rs.getString("role")
                );
            }

        } catch (SQLException e) {
            System.err.println("Erreur getByUsername : " + e.getMessage());
        }
        return null;
    }

    // Vérifier si un nom d'utilisateur existe déjà
    public boolean usernameExists(String username) {
        String sql = "SELECT COUNT(*) FROM users WHERE username = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Erreur usernameExists : " + e.getMessage());
            return false;
        }
    }

    // Vérifier si un email existe déjà
    public boolean emailExists(String email) {
        String sql = "SELECT COUNT(*) FROM users WHERE email = ?";
        try (Connection conn = DatabaseManager.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, email);
            ResultSet rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;

        } catch (SQLException e) {
            System.err.println("Erreur emailExists : " + e.getMessage());
            return false;
        }
    }
}
