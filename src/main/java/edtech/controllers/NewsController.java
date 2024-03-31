package edtech.controllers;

import edtech.dto.NewsCreateRequest;
import edtech.models.News;
import edtech.service.AdsService;
import edtech.service.NewsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edtech.constants.Routes.PATH_NEWS;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsController {
    Logger logger = LoggerFactory.getLogger(NewsController.class);

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
        logger.error("HELLO_TEST");
        newsService.create(request);
    }
}
