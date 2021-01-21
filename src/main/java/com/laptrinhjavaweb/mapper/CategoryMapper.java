package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.CategoryModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CategoryMapper implements RowMapper<CategoryModel> {
    @Override
    public CategoryModel mapRow(ResultSet resultSet) {
        try {
            CategoryModel categories = new CategoryModel();
            categories.setId(resultSet.getLong("id"));
            categories.setName(resultSet.getString("name"));
            categories.setCode(resultSet.getString("code"));
            return categories;
        } catch (SQLException e) {
            return null;
        }
    }
}
