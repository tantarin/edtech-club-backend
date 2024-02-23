package edtech.service;

import edtech.dto.AdsCreateRequest;
import edtech.dto.NewsCreateRequest;
import edtech.models.Ads;
import edtech.models.News;
import edtech.repository.AdsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {
    private final AdsRepository adsRepository;

    @Autowired
    public AdsService(AdsRepository adsRepository) {
        this.adsRepository = adsRepository;
    }

    public List<Ads> list() {
        var ads =  adsRepository.findAll();
        return ads;
    }

    public void create(AdsCreateRequest request) {
        Ads ads = new Ads();
        ads.setContent(request.getContent());
        ads.setHeader(request.getHeader());
        adsRepository.save(ads);
    }
}
