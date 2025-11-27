package com.shopmanage.dao;

import com.shopmanage.models.sale;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class SaleDAO {

    public boolean add(sale sale) {
        String query = "INSERT INTO sales(product_id, quantity, total, date) VALUES (?, ?, ?, ?)";

        try (PreparedStatement stmt = DatabaseManager.getConnection().prepareStatement(query)) {
            stmt.setInt(1, sale.getProductId());
            stmt.setInt(2, sale.getQuantity());
            stmt.setDouble(3, sale.getTotal());
            stmt.setString(4, sale.getDate().toString());
            stmt.executeUpdate();
            return true;

        } catch (SQLException e) {
            System.out.println("[SaleDAO ERROR] " + e.getMessage());
            return false;
        }
    }

    public List<sale> getAll() {
        List<sale> list = new ArrayList<>();
        String query = "SELECT * FROM sales";

        try (Statement stmt = DatabaseManager.getConnection().createStatement();
             ResultSet rs = stmt.executeQuery(query)) {

            while (rs.next()) {
                list.add(new sale(
                        rs.getInt("id"),
                        rs.getInt("product_id"),
                        rs.getInt("quantity"),
                        rs.getDouble("total"),
                        LocalDateTime.parse(rs.getString("date"))
                ));
            }

        } catch (SQLException e) {
            System.out.println("[SaleDAO ERROR] " + e.getMessage());
        }

        return list;
    }
}
