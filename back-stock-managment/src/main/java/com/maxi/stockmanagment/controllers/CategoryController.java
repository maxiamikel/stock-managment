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

import com.maxi.stockmanagment.domains.Category;
import com.maxi.stockmanagment.services.implementation.CategoryServiceImplementation;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImplementation categoryService;

    @GetMapping
    public ResponseEntity<List<Category>> getAll() {
        return new ResponseEntity<List<Category>>(this.categoryService.getAll(), HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Category> getById(@PathVariable("id") Long idCAtegory) {
        return new ResponseEntity<Category>(this.categoryService.getById(idCAtegory), HttpStatus.ACCEPTED);
    }

    @PostMapping("/save")
    public ResponseEntity<Category> save(@RequestBody Category category) {
        return new ResponseEntity<Category>(this.categoryService.save(category), HttpStatus.CREATED);
    }
}
