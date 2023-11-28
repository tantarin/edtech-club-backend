package com.bezkoder.spring.security.postgresql.service;

import com.bezkoder.spring.security.postgresql.models.Ads;
import com.bezkoder.spring.security.postgresql.models.News;
import com.bezkoder.spring.security.postgresql.repository.AdsRepository;
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
