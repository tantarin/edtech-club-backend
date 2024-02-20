package edtech.mapper;

import edtech.dto.AdsResponse;
import edtech.models.Ads;
import org.mapstruct.Mapper;

@Mapper
public interface AdsMapper {
    AdsResponse toAdsResponse(Ads entity);
}
