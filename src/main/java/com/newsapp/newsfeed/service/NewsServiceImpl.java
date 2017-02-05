package com.newsapp.newsfeed.service;

import com.newsapp.newsfeed.dao.NewsDao;
import com.newsapp.newsfeed.model.News;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService{
    private NewsDao newsDao;

    public void setNewsDao(NewsDao newsDao){ this.newsDao = newsDao; }

    @Override
    @Transactional
    public void addNews(News news) {
        this.newsDao.addNews(news);
    }

    @Override
    @Transactional
    public void removeNews(int id) {
        this.newsDao.removeNews(id);
    }

    @Override
    @Transactional
    public void updateNews(News news) {
        this.newsDao.updateNews(news);
    }

    @Override
    @Transactional
    public News getNewsById(int id) {
        return this.newsDao.getNewsById(id);
    }

    @Override
    @Transactional
    public List<News> getListNews() {
        return this.newsDao.getListNews();
    }

    @Override
    public List<News> getListNewsByTitle(String title) {
        return this.newsDao.getListNewsByTitle(title);
    }

    @Override
    @Transactional
    public List<News> getListNewsByCategory(String category) {
        return this.newsDao.getListNewsByCategory(category);
    }

    @Override
    @Transactional
    public List<News> getListNewsByTitleAndCategory(String title, String category) {
        return this.newsDao.getListNewsByTitleAndCategory(title, category);
    }

    @Override
    @Transactional
    public List<String> getListCategorys() {
        return this.newsDao.getListCategorys();
    }
}
