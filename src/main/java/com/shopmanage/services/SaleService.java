package com.shopmanage.services;

import com.shopmanage.dao.ProductDAO;
import com.shopmanage.dao.SaleDAO;
import com.shopmanage.models.sale;
import com.shopmanage.models.Product;

import java.util.List;

public class SaleService {

    private final SaleDAO saleDAO;
    private final ProductDAO productDAO;

    public SaleService(SaleDAO saleDAO, ProductDAO productDAO) {
        this.saleDAO = saleDAO;
        this.productDAO = productDAO;
    }

    /**
     * Ajoute une vente et met à jour le stock du produit
     */
    public boolean addSale(sale sale) {
        Product product = productDAO.getById(sale.getProductId());
        if (product == null || product.getStock() < sale.getQuantity()) {
            return false;
        }

        boolean added = saleDAO.add(sale);
        if (added) {
            productDAO.updateStock(product.getId(), product.getStock() - sale.getQuantity());
        }
        return added;
    }

    public List<sale> getAllSales() {
        return saleDAO.getAll();
    }
}
