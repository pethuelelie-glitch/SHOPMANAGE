package com.boutique.models;

/**
 * Classe qui représente un produit dans la boutique
 * Contient toutes les informations d'un article vendu
 */
public class Produit {
    
    // === ATTRIBUTS ===
    private int id;             // Identifiant unique du produit
    private String nom;         // Nom du produit (ex: "Croissant")
    private double prix;        // Prix de vente (ex: 1.50)
    private String categorie;   // Catégorie (ex: "Boulangerie", "Boisson")
    private int stock;          // Quantité disponible en stock
    
    // === CONSTRUCTEURS ===
    
    /**
     * Constructeur vide - requis pour certaines opérations
     */
    public Produit() {
        // Constructeur sans paramètres
    }
    
    /**
     * Constructeur complet avec tous les paramètres
     * @param id Identifiant unique
     * @param nom Nom du produit
     * @param prix Prix de vente
     * @param categorie Catégorie du produit
     * @param stock Quantité en stock
     */
    public Produit(int id, String nom, double prix, String categorie, int stock) {
        this.id = id;
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.stock = stock;
    }
    
    /**
     * Constructeur pour nouveau produit (sans ID)
     * @param nom Nom du produit
     * @param prix Prix de vente
     * @param categorie Catégorie du produit
     * @param stock Quantité en stock
     */
    public Produit(String nom, double prix, String categorie, int stock) {
        this.nom = nom;
        this.prix = prix;
        this.categorie = categorie;
        this.stock = stock;
    }
    
    // === GETTERS ===
    
    /**
     * @return Identifiant unique du produit
     */
    public int getId() {
        return id;
    }
    
    /**
     * @return Nom du produit
     */
    public String getNom() {
        return nom;
    }
    
    /**
     * @return Prix de vente du produit
     */
    public double getPrix() {
        return prix;
    }
    
    /**
     * @return Catégorie du produit
     */
    public String getCategorie() {
        return categorie;
    }
    
    /**
     * @return Quantité disponible en stock
     */
    public int getStock() {
        return stock;
    }
    
    // === SETTERS ===
    
    /**
     * Définit l'identifiant du produit
     * @param id Nouvel identifiant
     */
    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Définit le nom du produit
     * @param nom Nouveau nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }
    
    /**
     * Définit le prix du produit
     * @param prix Nouveau prix (doit être positif)
     */
    public void setPrix(double prix) {
        if (prix >= 0) {
            this.prix = prix;
        }
    }
    
    /**
     * Définit la catégorie du produit
     * @param categorie Nouvelle catégorie
     */
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }
    
    /**
     * Définit la quantité en stock
     * @param stock Nouvelle quantité (doit être positive)
     */
    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        }
    }
    
    // === MÉTHODES UTILES ===
    
    /**
     * Réduit le stock d'une certaine quantité
     * @param quantite Quantité à retirer du stock
     * @return true si opération réussie, false si stock insuffisant
     */
    public boolean retirerStock(int quantite) {
        if (quantite > 0 && this.stock >= quantite) {
            this.stock -= quantite;
            return true;
        }
        return false;
    }
    
    /**
     * Ajoute une quantité au stock
     * @param quantite Quantité à ajouter au stock
     */
    public void ajouterStock(int quantite) {
        if (quantite > 0) {
            this.stock += quantite;
        }
    }
    
    /**
     * Vérifie si le produit est en rupture de stock
     * @return true si stock <= 0
     */
    public boolean estEnRupture() {
        return this.stock <= 0;
    }
    
    /**
     * Représentation textuelle du produit
     * @return String décrivant le produit
     */
    @Override
    public String toString() {
        return String.format("Produit [id=%d, nom=%s, prix=%.2f€, catégorie=%s, stock=%d]", 
                            id, nom, prix, categorie, stock);
    }
    
    /**
     * Compare deux produits par leur identifiant
     * @param obj Objet à comparer
     * @return true si les produits ont le même ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Produit produit = (Produit) obj;
        return id == produit.id;
    }
}