package edtech.service;

import edtech.dto.NewsCreateRequest;
import edtech.models.News;
import edtech.repository.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public NewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public List<News> list() {
        var news =  newsRepository.findAll();
        return news;
    }

    public void create(NewsCreateRequest request) {
        News news = new News();
        news.setContent(request.getContent());
        news.setHeader(request.getHeader());
        newsRepository.save(news);
    }
}
