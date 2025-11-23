package com.boutique.models;
import java.time.LocalDateTime;

/**
 * Classe qui représente une transaction de vente
 * Enregistre une vente effectuée par un vendeur
 */
public class Vente {
    
    // === ATTRIBUTS ===
    private int id;                     // Identifiant unique de la vente
    private LocalDateTime dateVente;    // Date et heure de la vente
    private double montantTotal;        // Montant total de la vente
    private int vendeurId;              // ID du vendeur qui a effectué la vente
    
    // === CONSTRUCTEURS ===
    
    /**
     * Constructeur vide
     */
    public Vente() {
    }
    
    /**
     * Constructeur complet
     */
    public Vente(int id, LocalDateTime dateVente, double montantTotal, int vendeurId) {
        this.id = id;
        this.dateVente = dateVente;
        this.montantTotal = montantTotal;
        this.vendeurId = vendeurId;
    }
    
    /**
     * Constructeur pour nouvelle vente (sans ID, date automatique)
     */
    public Vente(double montantTotal, int vendeurId) {
        this.dateVente = LocalDateTime.now();  // Date actuelle automatique
        this.montantTotal = montantTotal;
        this.vendeurId = vendeurId;
    }
    
    // === GETTERS ===
    
    public int getId() {
        return id;
    }
    
    public LocalDateTime getDateVente() {
        return dateVente;
    }
    
    public double getMontantTotal() {
        return montantTotal;
    }
    
    public int getVendeurId() {
        return vendeurId;
    }
    
    // === SETTERS ===
    
    public void setId(int id) {
        this.id = id;
    }
    
    public void setDateVente(LocalDateTime dateVente) {
        this.dateVente = dateVente;
    }
    
    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }
    
    public void setVendeurId(int vendeurId) {
        this.vendeurId = vendeurId;
    }
    
    // === MÉTHODES UTILES ===
    
    /**
     * Formate la date pour l'affichage
     * @return Date formatée (ex: "15/12/2024 14:30")
     */
   public String getDateFormatee() {
    if (this.dateVente == null) {
        return "Date non définie";
    }
    return dateVente.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm"));
    }
    
    /**
     * Vérifie si la vente est d'aujourd'hui
     * @return true si la vente a eu lieu aujourd'hui
     */
    public boolean estVenteDuJour() {
        return dateVente.toLocalDate().equals(LocalDateTime.now().toLocalDate());
    }
    
    /**
     * Représentation textuelle
     */
    @Override
    public String toString() {
        return String.format("Vente [id=%d, date=%s, montant=%.2f€, vendeurId=%d]", 
                            id, getDateFormatee(), montantTotal, vendeurId);
    }
    
    /**
     * Compare deux ventes par leur ID
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Vente vente = (Vente) obj;
        return id == vente.id;
    }
}