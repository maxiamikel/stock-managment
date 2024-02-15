package com.maxi.stockmanagment.services;

import java.util.List;

import com.maxi.stockmanagment.domains.Category;

public interface CategoryService {
    public List<Category> getAll();

    public Category getById(Long idCategory);

    public Category save(Category category);
}
