package edtech.service;

import edtech.dto.AdsCreateRequest;
import edtech.models.Ads;
import edtech.models.User;
import edtech.repository.AdsRepository;
import edtech.repository.UserRepository;
import edtech.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
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
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        UserDetails userDetails = (UserDetails) auth.getPrincipal();
        User user = userRepository.findByUsername(userDetails.getUsername())
                .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));

        Ads ads = new Ads();
        ads.setContent(request.getContent());
        ads.setHeader(request.getHeader());
        ads.setUser(user);
        adsRepository.save(ads);
    }
}
