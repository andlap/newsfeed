package com.newsapp.newsfeed.dao;

import com.newsapp.newsfeed.model.News;

import java.util.List;

public interface NewsDao {
    public void addNews(News news);
    public void removeNews(int id);
    public void updateNews(News news);
    public News getNewsById(int id);
    public List<News> getListNews();
    public List<News> getListNewsByTitle(String title);
    public List<News> getListNewsByCategory(String category);
    public List<News> getListNewsByTitleAndCategory(String title, String category);
    public List<String> getListCategorys();
}
