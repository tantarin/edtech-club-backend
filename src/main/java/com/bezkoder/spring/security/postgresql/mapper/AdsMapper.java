package com.bezkoder.spring.security.postgresql.mapper;

import com.bezkoder.spring.security.postgresql.dto.AdsResponse;
import com.bezkoder.spring.security.postgresql.models.Ads;
import org.mapstruct.Mapper;

@Mapper
public interface AdsMapper {
    AdsResponse toAdsResponse(Ads entity);
}
