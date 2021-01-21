package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.CategoryModel;

import java.util.List;

public interface ICategoryDAO extends GenericDAO<CategoryModel> {
    //SELECT * FROM category
    List<CategoryModel> findAll();
}
