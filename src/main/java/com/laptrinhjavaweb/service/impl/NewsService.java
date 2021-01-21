package com.laptrinhjavaweb.service.impl;

import com.laptrinhjavaweb.dao.INewsDAO;
import com.laptrinhjavaweb.model.NewsModel;
import com.laptrinhjavaweb.service.INewsService;

import javax.inject.Inject;
import java.util.List;

public class NewsService implements INewsService {

    @Inject
    private INewsDAO newsDAO;

    @Override
    public List<NewsModel> findByCategoryId(Long categoryId) {
        return newsDAO.findByCategoryId(categoryId);
    }

    @Override
    public NewsModel save(NewsModel newsModel) {
        Long newsId = newsDAO.save(newsModel);
        System.out.println(newsId);
        return null;
    }

    @Override
    public void update(NewsModel updateModel) {
        newsDAO.update(updateModel);
    }

    @Override
    public void delete(NewsModel deleteModel) {
        newsDAO.delete(deleteModel);
    }
}
