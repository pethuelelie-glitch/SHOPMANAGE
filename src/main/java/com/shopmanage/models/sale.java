package com.shopmanage.models;

import java.time.LocalDateTime;

public class sale {
    private int id;
    private int productId;
    private int quantity;
    private double total;
    private LocalDateTime date;

    public sale() {}

    public sale(int id, int productId, int quantity, double total, LocalDateTime date) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    public sale(int productId, int quantity, double total, LocalDateTime date) {
        this.productId = productId;
        this.quantity = quantity;
        this.total = total;
        this.date = date;
    }

    // Getters & Setters
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public int getProductId() { return productId; }
    public void setProductId(int productId) { this.productId = productId; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotal() { return total; }
    public void setTotal(double total) { this.total = total; }

    public LocalDateTime getDate() { return date; }
    public void setDate(LocalDateTime date) { this.date = date; }
}
