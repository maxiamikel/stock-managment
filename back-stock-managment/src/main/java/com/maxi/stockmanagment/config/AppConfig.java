package com.maxi.stockmanagment.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.maxi.stockmanagment.repositories.ProductRepository;
import com.maxi.stockmanagment.repositories.UserRepository;
import com.maxi.stockmanagment.services.implementation.ProductServiceImplementation;
import com.maxi.stockmanagment.services.implementation.UserServiceImplementation;

@Configuration
public class AppConfig {

    @Bean
    public UserServiceImplementation userServiceImplementation(UserRepository userRepository) {
        return new UserServiceImplementation(userRepository);
    }

    @Bean
    public ProductServiceImplementation productServiceImplementation(ProductRepository productRepository) {
        return new ProductServiceImplementation(productRepository);
    }

    // @Bean
    // private OrderServiceImplementation orderServiceImplementation(OrderRepository
    // orderRepository) {
    // return new OrderServiceImplementation(orderRepository);
    // }
}
