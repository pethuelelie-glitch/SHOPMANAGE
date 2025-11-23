package com.boutique.models;

/**
 * Classe qui représente un utilisateur de l'application
 * Peut être un administrateur ou un vendeur
 */
public class Utilisateur {
    
    // === ATTRIBUTS ===
    private int id;                 // Identifiant unique
    private String nom;             // Nom complet
    private String email;           // Adresse email (utilisée pour login)
    private String role;            // Rôle: "ADMIN" ou "VENDEUR"
    private String motDePasseHash;  // Mot de passe haché (ne jamais stocker en clair!)
    
    // === CONSTRUCTEURS ===
    
    /**
     * Constructeur vide
     */
    public Utilisateur() {
    }
    
    /**
     * Constructeur complet
     */
    public Utilisateur(int id, String nom, String email, String role, String motDePasseHash) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.motDePasseHash = motDePasseHash;
    }
    
    /**
     * Constructeur pour nouvel utilisateur (sans ID)
     */
    public Utilisateur(String nom, String email, String role, String motDePasseHash) {
        this.nom = nom;
        this.email = email;
        this.role = role;
        this.motDePasseHash = motDePasseHash;
    }
    
    // === GETTERS ===
    
    public int getId() {
        return id;
    }
    
    public String getNom() {
        return nom;
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getRole() {
        return role;
    }
    
    public String getMotDePasseHash() {
        return motDePasseHash;
    }
    
    // === SETTERS ===
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    
    public void setMotDePasseHash(String motDePasseHash) {
        this.motDePasseHash = motDePasseHash;
    }
    
    // === MÉTHODES UTILES ===
    
    /**
     * Vérifie si l'utilisateur est un administrateur
     * @return true si rôle = "ADMIN"
     */
    public boolean estAdmin() {
        return "ADMIN".equals(this.role);
    }
    
    /**
     * Vérifie si l'utilisateur est un vendeur
     * @return true si rôle = "VENDEUR"
     */
    public boolean estVendeur() {
        return "VENDEUR".equals(this.role);
    }
    
    /**
     * Représentation textuelle
     */
    @Override
    public String toString() {
        return String.format("Utilisateur [id=%d, nom=%s, email=%s, role=%s]", 
                            id, nom, email, role);
    }
    
    /**
     * Compare deux utilisateurs par leur ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Utilisateur that = (Utilisateur) obj;
        return id == that.id;
    }
}