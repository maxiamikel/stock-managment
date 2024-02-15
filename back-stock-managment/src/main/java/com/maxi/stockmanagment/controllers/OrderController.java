package com.maxi.stockmanagment.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.maxi.stockmanagment.domains.Order;
import com.maxi.stockmanagment.services.implementation.OrderServiceImplementation;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderServiceImplementation orderService;

    @GetMapping
    public ResponseEntity<List<Order>> getAll() {
        return new ResponseEntity<List<Order>>(this.orderService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Order> getById(@PathVariable("id") Long idOrder) {
        return new ResponseEntity<Order>(this.orderService.getById(idOrder), HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Order> save(@RequestBody Order order) {
        return new ResponseEntity<Order>(this.orderService.save(order), HttpStatus.CREATED);
    }
}
