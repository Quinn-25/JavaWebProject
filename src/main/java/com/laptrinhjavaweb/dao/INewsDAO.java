package com.laptrinhjavaweb.dao;

import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface INewsDAO extends GenericDAO<NewsModel> {
    //SELECT
    List<NewsModel> findByCategoryId(Long categoryId);
    //INSERT
    Long save(NewsModel newsModel); //dùng Long thay void để lấy ID của table
    //UPDATE
    void update(NewsModel updateModel);
    //DELETE
    void delete(NewsModel deleteModel);
}
