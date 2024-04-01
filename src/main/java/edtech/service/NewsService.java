package edtech.service;

import edtech.controllers.NewsController;
import edtech.dto.NewsCreateRequest;
import edtech.dto.NewsResponse;
import edtech.models.News;
import edtech.repository.NewsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class NewsService {
    Logger logger = LoggerFactory.getLogger(NewsService.class);

    private final FilesStorageService filesStorageService;
    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(FilesStorageService filesStorageService,
                       NewsRepository newsRepository) {
        this.filesStorageService = filesStorageService;
        this.newsRepository = newsRepository;
    }

    public List<NewsResponse> list() throws IOException {
        var news =  newsRepository.findAll();
        List<NewsResponse> listResponse = new ArrayList<>();
        for (var n : news) {
            NewsResponse newsResponse = new NewsResponse();
            newsResponse.setId(n.getId());
            newsResponse.setContent(n.getContent());
            newsResponse.setHeader(n.getHeader());
            var image = filesStorageService.load(String.valueOf(n.getId()));
            newsResponse.setImage(image.getContentAsByteArray());
            listResponse.add(newsResponse);
        }
        return listResponse;
    }

    public Long create(NewsCreateRequest request) {
        News news = new News();
        news.setContent(request.getContent());
        news.setHeader(request.getHeader());
        news.setDate(LocalDate.now());
        return newsRepository.save(news).getId();
    }
}
