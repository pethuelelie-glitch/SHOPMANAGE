package database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class database {
    private static final String DB_URL = "jdbc:sqlite:shopmanage.db";
    private static Connection connection;

    public static Connection getConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(DB_URL);
                System.out.println("Connexion à SQLite réussie !");
            } catch (SQLException e) {
                System.err.println("Erreur de connexion SQLite : " + e.getMessage());
            }
        }
        return connection;
    }

    public static void initialize() {
        try (Statement stmt = getConnection().createStatement()) {

            String sqlProducts = """
                CREATE TABLE IF NOT EXISTS products (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    price REAL NOT NULL,
                    quantity INTEGER NOT NULL,
                    category TEXT,
                    created_at TEXT DEFAULT CURRENT_TIMESTAMP
                );
                """;

            String sqlUsers = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    username TEXT UNIQUE NOT NULL,
                    password TEXT NOT NULL,
                    role TEXT NOT NULL,
                    created_at TEXT DEFAULT CURRENT_TIMESTAMP
                );
                """;

            String sqlSales = """
                CREATE TABLE IF NOT EXISTS sales (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    product_id INTEGER NOT NULL,
                    quantity INTEGER NOT NULL,
                    total_price REAL NOT NULL,
                    sold_at TEXT DEFAULT CURRENT_TIMESTAMP,
                    sold_by INTEGER,
                    FOREIGN KEY(product_id) REFERENCES products(id),
                    FOREIGN KEY(sold_by) REFERENCES users(id)
                );
                """;

            stmt.execute(sqlProducts);
            stmt.execute(sqlUsers);
            stmt.execute(sqlSales);

            System.out.println("Tables créées avec succès !");
        } catch (SQLException e) {
            System.err.println("Erreur lors de la création des tables : " + e.getMessage());
        }
    }
}
