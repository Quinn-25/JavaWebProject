package com.laptrinhjavaweb.service;

import com.laptrinhjavaweb.model.NewsModel;

import java.util.List;

public interface INewsService {
    List<NewsModel> findByCategoryId(Long categoryId);
    NewsModel save(NewsModel newsModel);
    void update(NewsModel updateModel);
    void delete(NewsModel deleteModel);
}
