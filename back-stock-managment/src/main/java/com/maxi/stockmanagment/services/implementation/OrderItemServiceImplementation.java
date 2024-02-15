package com.maxi.stockmanagment.services.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.stockmanagment.domains.OrderItem;
import com.maxi.stockmanagment.repositories.OrderItemRepository;
import com.maxi.stockmanagment.services.OrderItemService;

@Service
public class OrderItemServiceImplementation implements OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    @Override
    public OrderItem save(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }
}
