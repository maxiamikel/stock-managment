package com.maxi.stockmanagment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.stockmanagment.domains.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
