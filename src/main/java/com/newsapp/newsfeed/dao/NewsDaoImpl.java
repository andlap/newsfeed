package com.newsapp.newsfeed.dao;

import com.newsapp.newsfeed.model.News;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class NewsDaoImpl implements NewsDao{
    private static Logger logger = LoggerFactory.getLogger(NewsDaoImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(news);
        logger.info("News " + news.getTitle() + " added. News info: " + news.toString());
    }

    @Override
    public void removeNews(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Integer(id));

        if(news!=null) {
            session.delete(news);
            logger.info("News deleted. News info: " + news.toString());
        }
    }

    @Override
    public void updateNews(News news) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(news);
        logger.info("News " + news.getTitle() + " updated. News info: " + news.toString());
    }

    @Override
    public News getNewsById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        News news = (News) session.load(News.class, new Integer(id));

        logger.info("News loaded. News info: " + news.toString());
        return news;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> getListNews() {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("from News").list();

        newsList.stream().forEach(news->logger.info("News list: " + news));

        return newsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> getListNewsByTitle(String title) {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("from News N where N.title like :title").setParameter("title", title).list();

        newsList.stream().forEach(news->logger.info("News list: " + news));

        return newsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> getListNewsByCategory(String category) {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList = session.createQuery("from News N WHERE N.category like :category").setParameter("category", category).list();

        newsList.stream().forEach(news->logger.info("News list: " + news));

        return newsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<News> getListNewsByTitleAndCategory(String title, String category) {
        Session session = this.sessionFactory.getCurrentSession();
        List<News> newsList;
        if (title.isEmpty() || title.equals(""))
            newsList = getListNewsByCategory(category);
        else if(category.isEmpty() || category.equals("NONE"))
            newsList = getListNewsByTitle(title);
        else
            newsList = session.createQuery("from News N WHERE N.category like :category and N.title like :title").setParameter("category", category).setParameter("title", title).list();

        newsList.stream().forEach(news->logger.info("News list: " + news));

        return newsList;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<String> getListCategorys() {
        Session session = this.sessionFactory.getCurrentSession();
        List<String> categorysList = session.createQuery("select category from News").list();

        categorysList = categorysList.stream().distinct().collect(Collectors.toList());

        return categorysList;
    }
}
