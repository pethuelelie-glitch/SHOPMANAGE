package com.shopmanage.models;

import org.mindrot.jbcrypt.BCrypt;

public class user {

    private int id; // champ id ajouté
    private String username;
    private String password;
    private String email;
    private String fullName;
    private String role;

    // Constructeur sans id (pour la création)
    public user(String username, String password, String email, String fullName, String role) {
        this.username = username;
        this.password = password; // le hash sera fait dans le DAO
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }

    // Constructeur avec id (pour la récupération depuis la BDD)
    public user(int id, String username, String password, String email, String fullName, String role) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.fullName = fullName;
        this.role = role;
    }

    // Getters et setters
    public int getId() { return id; }
    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getEmail() { return email; }
    public String getFullName() { return fullName; }
    public String getRole() { return role; }

    public void setId(int id) { this.id = id; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }
    public void setEmail(String email) { this.email = email; }
    public void setFullName(String fullName) { this.fullName = fullName; }
    public void setRole(String role) { this.role = role; }

    // Vérifier le mot de passe
    public boolean checkPassword(String plainPassword) {
        return BCrypt.checkpw(plainPassword, this.password);
    }
}
