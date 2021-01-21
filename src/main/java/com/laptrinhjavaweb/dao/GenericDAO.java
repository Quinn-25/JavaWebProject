package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.mapper.RowMapper;
import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface GenericDAO<T> {
    //Common method to SELECT data
    <T> List<T> query(String sql, RowMapper<T> rowMapper, Object... parameters); //Object... parameter -> 1 mảng gồm nhiều tham số (multyparam)

    //Common method to update and delete data
    void update(String sql, Object... parameters);

    //Common method to insert data and return its ID
    Long insert(String sql, Object... parameters);
}
