package com.bezkoder.spring.security.postgresql.controllers;

import com.bezkoder.spring.security.postgresql.dto.NewsCreateRequest;
import com.bezkoder.spring.security.postgresql.models.News;
import com.bezkoder.spring.security.postgresql.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static com.bezkoder.spring.security.postgresql.config.Routes.PATH_NEWS;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsController {

    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(PATH_NEWS)
    public List<News> list() {
        return newsService.list();
    }

    @PostMapping(PATH_NEWS)
    public void create(@RequestBody NewsCreateRequest request) {
        newsService.create(request);
    }
}
