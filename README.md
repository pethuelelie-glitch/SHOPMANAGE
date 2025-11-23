# 🏪 ShopManage - Application de Gestion de Boutique

## 📋 Description
**ShopManage** est une application JavaFX complète conçue pour simplifier la gestion quotidienne des petites boutiques. Elle permet de gérer les produits, les ventes, le stock et les utilisateurs grâce à une interface intuitive et moderne.

## 🚀 Fonctionnalités Principales

### 👨‍💼 Administration
- **Tableau de bord** avec indicateurs clés
- **Gestion complète du catalogue** produits (ajout, modification, suppression)
- **Gestion des comptes** vendeurs et administrateurs
- **Statistiques** de ventes et performances

### 💼 Vente au Quotidien
- **Interface de caisse** optimisée pour la rapidité
- **Recherche instantanée** de produits
- **Gestion du panier** avec calcul automatique
- **Historique des ventes** avec filtres par date

### 🔐 Sécurité
- **Système d'authentification** sécurisé
- **Gestion des rôles** (Administrateur/Vendeur)
- **Hachage des mots de passe**
- **Sessions utilisateur** contrôlées

## 🛠️ Technologies Utilisées
- **Java 17** - Langage de programmation
- **JavaFX** - Interface utilisateur moderne
- **SQLite** - Base de données embarquée
- **Architecture MVC** - Organisation du code

## 📁 Structure du Projet
shopmanage/
│
├── src/
│   ├── main/
│       ├── java/com/boutique/
│       │   ├── controllers/        # Logique des pages (JavaFX)
│       │   ├── models/             # Classes : Produit, Vente, Utilisateur...
│       │   ├── dao/                # SQLite CRUD
│       │   ├── services/           # Logique métier
│       │   ├── utils/              # Helpers
│       │   └── App.java            # Main
│       │
│       ├── resources/
│       │   ├── views/              # FXML
│       │   ├── css/                # Styles
│       │   └── images/             # Images produits
│       │
│       └── db/
│           └── boutique.db         # Base SQLite
│
├── README.md
└── pom.xml / build.gradle


## 🏗️ Architecture

L'application suit une architecture **MVC (Modèle-Vue-Contrôleur)** avec séparation claire des responsabilités :

- **Modèles** : Représentent les données métier
- **Vues** : Interfaces utilisateur (FXML)
- **Contrôleurs** : Gèrent les interactions
- **Services** : Contiennent la logique métier
- **DAO** : Gèrent la persistance des données

## 👥 Équipe de Développement

- **Personne 1** - Base de données et infrastructure
- **Personne 2** - Modèles de données
- **Personne 3** - Accès aux données (DAO)
- **Personne 4** - Services métier
- **Personne 5** - Interface administrateur
- **Personne 6** - Interface vendeur
- **Personne 7** - Authentification et sécurité

## 📦 Installation et Démarrage

### Prérequis
- Java JDK 17 ou supérieur
- JavaFX SDK 17 ou supérieur

### Installation
```bash
# Cloner le repository
git clone https://github.com/pethuelelie-glitch/SHOPMANAGE.git

# Se positionner dans le dossier
cd shopmanage