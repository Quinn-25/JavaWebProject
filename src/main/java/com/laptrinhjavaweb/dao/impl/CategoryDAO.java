package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.ICategoryDAO;
import com.laptrinhjavaweb.mapper.CategoryMapper;
import com.laptrinhjavaweb.model.CategoryModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO { //T type = CategoryModel

    @Override
    public List<CategoryModel> findAll() {
        String sql = "SELECT * FROM category";
        /*CategoryMapper categoryMapper = new CategoryMapper();
        return query(sql, categoryMapper);*/
        return query(sql, new CategoryMapper());
    }
}
