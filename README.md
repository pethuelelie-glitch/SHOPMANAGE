Parfait ! Voici un **README.md refait** en utilisant exactement la structure que tu m’as donnée :

---

```markdown
# ShopManage

ShopManage est une **application de gestion de boutique** développée en Java avec JavaFX et SQLite.  
Elle permet de gérer les utilisateurs, les produits, les ventes et le stock avec une interface graphique simple et intuitive.

---

## Fonctionnalités

- **Gestion des utilisateurs**
  - Ajout et gestion des utilisateurs (admin, vendeur, user)
  - Connexion avec authentification
  - Redirection automatique selon le rôle de l’utilisateur

- **Gestion des produits**
  - Ajouter, modifier, supprimer des produits
  - Gestion des stocks et des prix

- **Gestion des ventes**
  - Enregistrement des ventes
  - Calcul du total
  - Historique des ventes

- **Interface graphique**
  - JavaFX pour l’interface utilisateur
  - FXML pour la structure des vues
  - CSS pour le style

---

## Structure du projet

```

src/
├── main/
│   ├── java/
│   │   └── com/shopmanage/
│   │       ├── Main.java
│   │       ├── models/
│   │       │   ├── User.java
│   │       │   ├── Product.java
│   │       │   └── Sale.java
│   │       ├── dao/
│   │       │   ├── DatabaseManager.java
│   │       │   ├── UserDAO.java
│   │       │   ├── ProductDAO.java
│   │       │   └── SaleDAO.java
│   │       ├── services/
│   │       │   ├── AuthService.java
│   │       │   ├── ProductService.java
│   │       │   └── SaleService.java
│   │       └── controllers/
│   │           ├── LoginController.java
│   │           ├── AdminController.java
│   │           └── VendorController.java
│   └── resources/
│       └── com/shopmanage/
│           ├── views/
│           │   ├── login.fxml
│           │   ├── admin.fxml
│           │   └── vendor.fxml
│           └── css/
│               └── style.css

````

---

## Installation

1. **Cloner le projet :**

```bash
git clone https://github.com/pethuelelie-glitch/SHOPMANAGE.git
````

2. **Ouvrir le projet dans IntelliJ IDEA**

   * Choisir **Open** et sélectionner le dossier du projet.

3. **Vérifier la configuration JavaFX**

   * Assurez-vous que JavaFX est configuré dans votre SDK/Module Settings.

4. **Compiler et lancer**

   * Pour Maven :

     ```bash
     mvn clean install
     mvn javafx:run
     ```
   * Pour Gradle :

     ```bash
     ./gradlew build
     ./gradlew run
     ```

---

## Technologies utilisées

* Java 20
* JavaFX 20
* SQLite
* Maven / Gradle
* FXML et CSS pour l’interface

---

