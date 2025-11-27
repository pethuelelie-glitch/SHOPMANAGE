package com.shopmanage.dao;

import com.shopmanage.models.Product;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    public boolean add(Product product) {
        String query = "INSERT INTO products(name, price, stock) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setDouble(2, product.getPrice());
            stmt.setInt(3, product.getStock());
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("[ProductDAO ERROR] " + e.getMessage());
            return false;
        }
    }

    public List<Product> getAll() {
        List<Product> list = new ArrayList<>();
        String query = "SELECT * FROM products";

        try (Statement stmt = DatabaseManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                list.add(new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                ));
            }

        } catch (SQLException e) {
            System.out.println("[ProductDAO ERROR] " + e.getMessage());
        }

        return list;
    }

    public Product getById(int id) {
        String query = "SELECT * FROM products WHERE id = ?";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(query)) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                return new Product(
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getDouble("price"),
                        rs.getInt("stock")
                );
            }

        } catch (SQLException e) {
            System.out.println("[ProductDAO ERROR] " + e.getMessage());
        }
        return null;
    }

    public boolean updateStock(int productId, int newStock) {
        String query = "UPDATE products SET stock = ? WHERE id = ?";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(query)) {
            stmt.setInt(1, newStock);
            stmt.setInt(2, productId);
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.out.println("[ProductDAO ERROR] " + e.getMessage());
            return false;
        }
    }
}
