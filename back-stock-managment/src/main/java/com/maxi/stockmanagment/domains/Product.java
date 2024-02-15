/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.maxi.stockmanagment.domains;

import com.maxi.stockmanagment.enums.ProductStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 *
 * @author maxlo
 */

@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    private Long quantity;
    private Double price;
    private String urlImage;

    @ManyToOne()
    private Category category;

    @Enumerated(EnumType.STRING)
    private ProductStatus productStatus;

    public Product(String name, String description, Long quantity, Double price, String urlImage, Category category) {
        this.name = name;
        this.description = description;
        this.quantity = quantity;
        this.price = price;
        this.urlImage = urlImage;
        this.category = category;
    }

}
