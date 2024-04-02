package edtech.service;

import edtech.dto.AdsCreateRequest;
import edtech.dto.AdsResponse;
import edtech.models.Ads;
import edtech.models.User;
import edtech.repository.AdsRepository;
import edtech.repository.UserRepository;
import edtech.security.services.UserDetailsImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdsService {
    Logger logger = LoggerFactory.getLogger(AdsService.class);

    private final AdsRepository adsRepository;
    private final UserRepository userRepository;

    @Autowired
    public AdsService(AdsRepository adsRepository, UserRepository userRepository) {
        this.adsRepository = adsRepository;
        this.userRepository = userRepository;
    }

    public List<AdsResponse> list() {
        List<AdsResponse> adsList = new ArrayList<>();
        var ads = adsRepository.findAll();
        for (var ad : ads) {
            AdsResponse adsResponse = new AdsResponse();
            adsResponse.setId(ad.getId());
            adsResponse.setContent(ad.getContent());
            adsResponse.setHeader(ad.getHeader());
            List<String> names = ad.getTags().stream()
                    .map(adTag -> adTag.getTags().getName())
                    .collect(Collectors.toList());
            adsResponse.setTags(names);
            adsList.add(adsResponse); // Добавляем созданный объект AdsResponse в список
        }
        return adsList;
    }


    public void create(AdsCreateRequest request) {
        logger.error("--------------------------------------------------------------------------------------------");
        logger.info("CREATE {}", request.getHeader());
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        if (!(auth instanceof AnonymousAuthenticationToken)) {
//            UserDetails userDetails =
//                    (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//            User user = userRepository.findByUsername(userDetails.getUsername())
//                    .orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + userDetails.getUsername()));
//            logger.info("LISTLISTLIST2" + user.getUsername());
//        }

        Ads ads = new Ads();
        ads.setContent(request.getContent());
        ads.setHeader(request.getHeader());
        ads.setUser(userRepository.findTopBy(Sort.by(Sort.Direction.ASC, "username")));
        adsRepository.save(ads);
    }

    public void deleteById(Long id) {
        adsRepository.deleteById(id);
    }
}
