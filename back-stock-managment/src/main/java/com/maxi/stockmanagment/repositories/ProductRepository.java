package com.maxi.stockmanagment.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.maxi.stockmanagment.domains.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p.quantity FROM Product p WHERE p.id =:idProduct")
    public Long findByQuantity(@RequestParam("idProduct") Long idProduct);

    @Query("SELECT p FROM Product p WHERE p.productStatus = ENABLE")
    public List<Product> findAll();
}
