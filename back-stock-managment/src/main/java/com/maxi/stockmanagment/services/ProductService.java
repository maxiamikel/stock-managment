package com.maxi.stockmanagment.services;

import java.util.List;

import com.maxi.stockmanagment.domains.Product;

public interface ProductService {
    public List<Product> getAll();

    public Product getById(Long idProduct);

    public Product save(Product product);

    public Product update(Product product);

    public void updateStock(Long idProduct, Long quantity);

    public void desactivateProduct(Long idProduct);

    public void activateProduct(Long idProduct);

    public Long findByQuantity(Long idProduct);

    public boolean veriryStockBeforeEffectuateAnOrder(Long idProduct, Long quantity);
}
