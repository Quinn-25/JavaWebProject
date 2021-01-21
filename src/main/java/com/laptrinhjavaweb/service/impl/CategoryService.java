package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.dao.impl.CategoryDAO;
import com.laptrinhjavaweb.model.CategoryModel;
import com.laptrinhjavaweb.service.ICategoryService;

import javax.inject.Inject;
import java.util.List;

public class CategoryService implements ICategoryService {
    /*// Simple Method
    // Method to user findAll() in ICategoryDAO
    private ICategoryDAO categoryDAO;

    //Create a constructor
    public CategoryService() {
        categoryDAO = new CategoryDAO();
    }*/

    // Context Dependency Injection using Java Servlet Weld
    @Inject //annotation
    private ICategoryDAO categoryDAO;

    @Override
    public List<CategoryModel> findAll() {
        return categoryDAO.findAll();
    }
}
