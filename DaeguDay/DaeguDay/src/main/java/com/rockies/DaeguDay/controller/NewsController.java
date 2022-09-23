package com.rockies.DaeguDay.controller;

import com.rockies.DaeguDay.domain.News;
import com.rockies.DaeguDay.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class NewsController {
    private final NewsService newsService;
    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping("/")
    public String test(){
        return "home";
    }

    @GetMapping("/News")
    public String list(Model model){
        List<News> newsList = newsService.findNewses();
        model.addAttribute("newses", newsList);
        return "News/newslist1";
    }
}