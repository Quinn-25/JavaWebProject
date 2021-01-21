package com.laptrinhjavaweb.mapper;

import com.laptrinhjavaweb.model.NewsModel;

import java.sql.ResultSet;
import java.sql.SQLException;

public class NewsMapper implements RowMapper<NewsModel> {

    @Override
    public NewsModel mapRow(ResultSet resultSet) {
        try {
            NewsModel news = new NewsModel();
            news.setId(resultSet.getLong("id"));
            news.setTitle(resultSet.getString("title"));
            news.setThumbnail(resultSet.getString("thumbnail"));
            news.setShortDescription(resultSet.getString("shortdescription"));
            news.setContent(resultSet.getString("content"));
            return news;
        } catch (SQLException e) {
            return null;
        }
    }
}
