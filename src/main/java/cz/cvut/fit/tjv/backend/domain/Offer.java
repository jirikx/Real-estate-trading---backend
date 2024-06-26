package cz.cvut.fit.tjv.backend.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offer implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_username")
    private User author;
    private Long price;
    private boolean isClosed;
    @Enumerated(EnumType.ORDINAL)
    private OfferType offerType;
    @ManyToMany(mappedBy = "favouriteOffers")
    private Set<User> favouritedBy;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "offer_info_id")
    private InformationPart offerInfo;

    public Offer(Long id, User author, Long price) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.isClosed = false;
    }

    public Offer(User author, Long price) {
        this.author = author;
        this.price = price;
        this.isClosed = false;
    }

    public Offer() {}

    @Override
    public Long getId() {
        return id;
    }

    public void closeOffer() {
        isClosed = true;
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

    public boolean isClosed() {
        return isClosed;
    }

    public boolean isOpen() {
        return !isClosed;
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

    public Set<User> getFavouritedBy() {
        return favouritedBy;
    }

    public void setFavouritedBy(Set<User> favouritedBy) {
        this.favouritedBy = favouritedBy;
    }

    public InformationPart getOfferInfo() {
        return offerInfo;
    }

    public void setOfferInfo(InformationPart offerInfo) {
        this.offerInfo = offerInfo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Offer offer = (Offer) o;

        return getId() != null ? getId().equals(offer.getId()) : offer.getId() == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
