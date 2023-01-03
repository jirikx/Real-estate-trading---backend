package cz.cvut.fit.tjv.backend.api.dto;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.OfferType;
import cz.cvut.fit.tjv.backend.domain.User;

import javax.persistence.*;
import java.util.Set;

public class OfferDto {
    private Long id;
    private User author;
    private Long price;
    private String description;
    private boolean isClosed;
    private OfferType offerType;
    private Set<Long> favouritedBy;
    private String offerInfo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public String getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(String offerInfo) {
        this.offerInfo = offerInfo;
    }
}
