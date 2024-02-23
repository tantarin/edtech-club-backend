package edtech.service;

import edtech.dto.AdsCreateRequest;
import edtech.models.Ads;
import edtech.models.User;
import edtech.repository.AdsRepository;
import edtech.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdsService {
    private final AdsRepository adsRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdsService(AdsRepository adsRepository, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.userRepository = userRepository;
    }

    public List<Ads> list() {
        var ads =  adsRepository.findAll();
        return ads;
    }

    public void create(AdsCreateRequest request) {
        Ads ads = new Ads();
        ads.setContent(request.getContent());
        ads.setHeader(request.getHeader());

        User user = new User();
        user.setId(16L);
        ads.setUser(userRepository.getById(16L));
        adsRepository.save(ads);
    }
}
