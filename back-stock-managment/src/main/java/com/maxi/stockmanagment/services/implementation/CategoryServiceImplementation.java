package com.maxi.stockmanagment.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maxi.stockmanagment.domains.Category;
import com.maxi.stockmanagment.repositories.CategoryRepository;
import com.maxi.stockmanagment.services.CategoryService;

@Service
public class CategoryServiceImplementation implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public List<Category> getAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getById(Long idCategory) {
        return categoryRepository.findById(idCategory).orElseThrow();
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

}
