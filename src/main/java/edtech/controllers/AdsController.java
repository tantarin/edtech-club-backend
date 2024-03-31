package edtech.controllers;

import edtech.dto.AdsCreateRequest;
import edtech.models.Ads;
import edtech.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edtech.constants.Routes.PATH_ADS;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdsController {

    private final AdsService adsService;

    @Autowired
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping(PATH_ADS)
    public List<Ads> list() {
        return adsService.list();
    }

    @PostMapping(PATH_ADS)
    public void create(@RequestBody AdsCreateRequest request) {
        adsService.create(request);
    }
}
