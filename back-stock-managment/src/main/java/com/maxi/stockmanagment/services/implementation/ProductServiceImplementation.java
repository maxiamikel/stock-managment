package com.maxi.stockmanagment.services.implementation;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.maxi.stockmanagment.domains.Product;
import com.maxi.stockmanagment.enums.ProductStatus;
import com.maxi.stockmanagment.repositories.ProductRepository;
import com.maxi.stockmanagment.services.ProductService;

public class ProductServiceImplementation implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product getById(Long idProduct) {
        Optional<Product> product = productRepository.findById(idProduct);
        return product.orElseThrow(null);
    }

    @Override
    public Product save(Product product) {

        product.setProductStatus(ProductStatus.ENABLE);
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        Product productDB = this.getById(product.getId());
        productDB.setDescription(product.getDescription());
        productDB.setName(product.getName());
        productDB.setPrice(product.getPrice());
        productDB.setUrlImage(product.getUrlImage());
        productDB.setQuantity(product.getQuantity());
        return productRepository.save(productDB);
    }

    @Override
    public void updateStock(Long idProduct, Long quantity) {
        Product product = this.getById(idProduct);
        product.setQuantity(product.getQuantity() - quantity);
        this.update(product);
    }

    @Override
    public boolean veriryStockBeforeEffectuateAnOrder(Long idProduct, Long quantity) {
        Product product = this.getById(idProduct);
        if (product.getQuantity() < quantity) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void desactivateProduct(Long idProduct) {
        Product product = this.getById(idProduct);
        product.setProductStatus(ProductStatus.DISABLE);
        this.update(product);
    }

    @Override
    public void activateProduct(Long idProduct) {
        Product product = this.getById(idProduct);
        product.setProductStatus(ProductStatus.DISABLE);
        this.update(product);
    }

    @Override
    public Long findByQuantity(Long idProduct) {
        return productRepository.findByQuantity(idProduct);
    }

}
