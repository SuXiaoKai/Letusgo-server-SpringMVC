package com.thoughtworks.letusgo.service;

import com.thoughtworks.letusgo.model.Category;

import java.util.List;

public interface CategoryService {
    List<Category> getCategories();

    Category getCategory();
}
