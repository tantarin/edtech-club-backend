package edtech.controllers;

import edtech.dto.NewsCreateRequest;
import edtech.models.News;
import edtech.service.FilesStorageService;
import edtech.service.NewsService;
import org.apache.tomcat.jni.FileInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.util.List;
import java.util.stream.Collectors;

import static edtech.constants.Routes.PATH_NEWS;
import static edtech.constants.Routes.PATH_NEWS_IMAGE;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class NewsController {
    Logger logger = LoggerFactory.getLogger(NewsController.class);

    private final NewsService newsService;
    private final FilesStorageService storageService;

    @Autowired
    public NewsController(NewsService newsService, FilesStorageService storageService) {
        this.newsService = newsService;
        this.storageService = storageService;
    }

    @GetMapping(PATH_NEWS)
    public List<News> list() {
        return newsService.list();
    }

    @PostMapping(PATH_NEWS)
    public void create(@RequestBody NewsCreateRequest request) {
        newsService.create(request);
    }

    @PostMapping(PATH_NEWS_IMAGE)
    public void uploadFile(@RequestParam("file") MultipartFile file) {
        logger.error("-------------- " + file.getName());
        storageService.save(file);
    }

    @GetMapping("/files/{filename:.+}")
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {
        Resource file = storageService.load(filename);
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
