package com.maxi.stockmanagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.stockmanagment.domains.Product;
import com.maxi.stockmanagment.services.implementation.ProductServiceImplementation;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private ProductServiceImplementation productService;

    @GetMapping
    public ResponseEntity<List<Product>> getAll() {
        return new ResponseEntity<List<Product>>(this.productService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> getById(@PathVariable("id") Long idProduct) {
        return new ResponseEntity<Product>(this.productService.getById(idProduct), HttpStatus.ACCEPTED);
    }

    // @PostMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PostMapping("/save")
    public ResponseEntity<Product> save(@RequestBody Product product) {
        return new ResponseEntity<Product>(this.productService.save(product), HttpStatus.CREATED);
    }

    // @PutMapping(consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @PutMapping()
    public ResponseEntity<Product> update(@RequestBody Product product) {
        return new ResponseEntity<Product>(this.productService.update(product), HttpStatus.ACCEPTED);
    }

}
