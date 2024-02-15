package com.maxi.stockmanagment.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maxi.stockmanagment.domains.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
