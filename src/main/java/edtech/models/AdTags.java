package edtech.models;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "ad_tags")
public class AdTags {
    @EmbeddedId
    private AdTagsId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ad_id", insertable = false, updatable = false)
    @NotNull
    private Ads ads;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tag_id", insertable = false, updatable = false)
    @NotNull
    private Tag tags;

    public AdTagsId getId() {
        return id;
    }

    public void setId(AdTagsId id) {
        this.id = id;
    }

    public Ads getAds() {
        return ads;
    }

    public void setAds(Ads ads) {
        this.ads = ads;
    }

    public Tag getTags() {
        return tags;
    }

    public void setTags(Tag tags) {
        this.tags = tags;
    }
}
