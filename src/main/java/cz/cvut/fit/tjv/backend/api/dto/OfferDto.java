package cz.cvut.fit.tjv.backend.api.dto;

import cz.cvut.fit.tjv.backend.domain.OfferType;

import java.util.Set;

public class OfferDto {
    private Long id;
    private Long author;
    private Long price;
    private boolean isClosed;
    private OfferType offerType;
    private Set<Long> favouritedBy;
    private Long offerInfo;

    public OfferDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public boolean isClosed() {
        return isClosed;
    }

    public void setClosed(boolean closed) {
        isClosed = closed;
    }

    public OfferType getOfferType() {
        return offerType;
    }

    public void setOfferType(OfferType offerType) {
        this.offerType = offerType;
    }

    public Set<Long> getFavouritedBy() {
        return favouritedBy;
    }

    public void setFavouritedBy(Set<Long> favouritedBy) {
        this.favouritedBy = favouritedBy;
    }

    public Long getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(Long offerInfo) {
        this.offerInfo = offerInfo;
    }
}
