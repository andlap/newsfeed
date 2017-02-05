package com.newsapp.newsfeed.controller;

import com.newsapp.newsfeed.model.News;
import com.newsapp.newsfeed.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewsController {
    private NewsService newsService;

    @Autowired(required = true)
    @Qualifier(value = "newsService")
    public void setNewsService(NewsService newsService){
        this.newsService = newsService;
    }

    @RequestMapping(value = "news", method = RequestMethod.GET)
    public String listNews(Model model){
        model.addAttribute("news", new News());
        model.addAttribute("listNews", this.newsService.getListNews());
        model.addAttribute("listCategorys", this.newsService.getListCategorys());

        return "news";
    }

    @RequestMapping(value = "news/findByTitle/{title}", method = RequestMethod.GET)
    public String listNewsByTitle(@PathVariable("title") String title, Model model){
        model.addAttribute("listNewsByTitle", this.newsService.getListNewsByTitle(title));

        return "redirect:/news";
    }

    @RequestMapping(value = "/findByCategory/{category}", method = RequestMethod.GET)
    public String listNewsByCategory(@PathVariable("category") String category, Model model){
        model.addAttribute("listNewsByCategory", this.newsService.getListNewsByCategory(category));

        return "findedNewsByCategory";
    }

    @RequestMapping(value = "/news/finded")
    public String listNewsByTitleAndCategory(@RequestParam("title") String title,@ModelAttribute("category") String category, Model model){
        model.addAttribute("listNewsByTitleAndCategory", this.newsService.getListNewsByTitleAndCategory(title, category));

        return "finded";
    }

    @RequestMapping(value = "news/add", method = RequestMethod.POST)
    public String addNews(@ModelAttribute("news") News news){
        if (news.getId() == 0)
            this.newsService.addNews(news);
        else
            this.newsService.updateNews(news);

        return "redirect:/news";
    }

    @RequestMapping("/remove/{id}")
    public String removeNews(@PathVariable("id") int id){
        this.newsService.removeNews(id);

        return "redirect:/news";
    }

    @RequestMapping("/edit/{id}")
    public String editNews(@PathVariable("id") int id, Model model){
        model.addAttribute("news", this.newsService.getNewsById(id));
        model.addAttribute("listNews", this.newsService.getListNews());

        return "news";
    }

    @RequestMapping("/newsinfo/{id}")
    public String newsData(@PathVariable("id") int id, Model model){
        model.addAttribute("news", this.newsService.getNewsById(id));

        return "newsinfo";
    }
}
