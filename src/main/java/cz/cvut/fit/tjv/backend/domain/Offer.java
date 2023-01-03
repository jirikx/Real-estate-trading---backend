package cz.cvut.fit.tjv.backend.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "offer_poly", discriminatorType = DiscriminatorType.INTEGER)
public class Offer implements CommonEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    @ManyToOne
    @JoinColumn(name = "author_username")
    private User author;
    private Long price;
    private String description;
    private boolean isClosed;
    private OfferType offerType;
    @ManyToMany
    @JoinTable(
            name = "favourited_by_users",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    private Set<User> favouritedBy;
    @OneToOne
    private InformationPart offerInfo;

    public Offer(User author, Long price, String description) {
        this.author = author;
        this.price = price;
        this.description = description;
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
}
