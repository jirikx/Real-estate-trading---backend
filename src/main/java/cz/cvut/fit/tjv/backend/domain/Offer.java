package cz.cvut.fit.tjv.backend.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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

    public Offer(Long id, User author, Long price, String description, OfferType offerType) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.description = description;
        this.isClosed = false;
        this.offerType = offerType;
    }

    public Offer() {}

    @Override
    public Long getId() {
        return id;
    }

    public void closeOffer() {
        isClosed = true;
    }

}
