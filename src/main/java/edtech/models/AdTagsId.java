package edtech.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

@Embeddable
public class AdTagsId implements Serializable {

    @NotNull
    @Column(name = "ad_id")
    private Long adId;

    @NotNull
    @Column(name = "tag_id")
    private Long tagId;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Long getTagId() {
        return tagId;
    }

    public void setTagId(Long tagId) {
        this.tagId = tagId;
    }
}
