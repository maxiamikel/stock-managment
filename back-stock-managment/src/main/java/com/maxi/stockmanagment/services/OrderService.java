package com.maxi.stockmanagment.services;

import java.util.List;

import com.maxi.stockmanagment.domains.Order;

public interface OrderService {
    public List<Order> getAll();

    public Order getById(Long idOrder);

    public Order save(Order order);
}
