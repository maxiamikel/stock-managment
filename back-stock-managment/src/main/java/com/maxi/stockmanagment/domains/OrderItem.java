package com.maxi.stockmanagment.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "items")
@Getter
@Setter
@NoArgsConstructor
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long quantity;
    private Double price;
    private Double total;

    @ManyToOne
    private Product product;

    @JsonIgnore
    @ManyToOne
    private Order order;

    public OrderItem(Long quantity, Double price, Double total, Product product, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.total = total;
        this.product = product;
        this.order = order;
    }

    public OrderItem(Long quantity, Double price, Product product, Order order) {
        this.quantity = quantity;
        this.price = price;
        this.product = product;
        this.order = order;
    }

}
