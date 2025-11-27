package com.shopmanage.services;

import com.shopmanage.dao.ProductDAO;
import com.shopmanage.models.Product;

import java.util.List;

public class ProductService {

    private final ProductDAO productDAO;

    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean addProduct(String name, double price, int stock) {
        Product product = new Product(name, price, stock);
        return productDAO.add(product);
    }

    public List<Product> getAllProducts() {
        return productDAO.getAll();
    }

    public Product getProductById(int id) {
        return productDAO.getById(id);
    }

    public boolean updateStock(int productId, int newStock) {
        return productDAO.updateStock(productId, newStock);
    }
}
