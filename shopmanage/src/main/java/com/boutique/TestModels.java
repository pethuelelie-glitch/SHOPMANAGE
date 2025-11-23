package com.boutique;

import com.boutique.models.Produit;
import com.boutique.models.Utilisateur;
import com.boutique.models.Vente;

public class TestModels {
    public static void main(String[] args) {
        System.out.println(" Test des modeles - Creation d'objets vides");
        
        // Créer des objets vides pour tester
        Produit p = new Produit();
        Utilisateur u = new Utilisateur();
        Vente v = new Vente();
        
        System.out.println(" Produit vide cree: " + p);
        System.out.println(" Utilisateur vide cree: " + u);
        System.out.println(" Vente vide creee: " + v);
        
        System.out.println(" Tous les modeles fonctionnent !");
    }
}