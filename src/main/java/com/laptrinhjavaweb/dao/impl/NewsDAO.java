package com.laptrinhjavaweb.dao.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.mapper.NewsMapper;
import com.laptrinhjavaweb.model.NewsModel;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class NewsDAO extends AbstractDAO<NewsModel> implements INewsDAO {

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        String sql = "SELECT * FROM news WHERE categoryid = ?";
        return query(sql, new NewsMapper(), categoryId);
    }

    @Override
    public Long save(NewsModel newsModel) {
        String sql = "INSERT INTO news (title, content, categoryId) VALUES (?, ?, ?)";
        return insert(sql, newsModel.getTitle(), newsModel.getContent(), newsModel.getCategoryId());
    }

    @Override
    public void update(NewsModel updateModel) {
        String sql = "UPDATE";
        update(sql, updateModel.getId());
    }

    @Override
    public void delete(NewsModel updateModel) {
        String sql = "DELETE FROM news WHERE id > ?";
        update(sql, updateModel.getId());
    }
}
