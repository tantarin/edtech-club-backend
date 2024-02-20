package edtech.service;

import edtech.models.Ads;
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
}
