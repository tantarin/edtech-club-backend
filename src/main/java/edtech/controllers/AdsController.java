package edtech.controllers;

import edtech.dto.AdsCreateRequest;
import edtech.dto.AdsResponse;
import edtech.models.Ads;
import edtech.service.AdsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static edtech.constants.Routes.PATH_ADS;
import static edtech.constants.Routes.PATH_ADS_ID;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class AdsController {

    private final AdsService adsService;

    @Autowired
    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping(PATH_ADS)
    public List<AdsResponse> list() {
        return adsService.list();
    }

    @PostMapping(PATH_ADS)
    public void create(@RequestBody AdsCreateRequest request) {
        adsService.create(request);
    }

    @DeleteMapping(PATH_ADS_ID)
    public void delete(@PathVariable Long id) {
        adsService.deleteById(id);
    }
}
