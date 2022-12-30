package cz.cvut.fit.tjv.backend.domain;

import org.springframework.boot.autoconfigure.condition.ConditionalOnJava;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Offer {
    @Id
    private Long id;

    @ManyToOne
    @JoinColumn(name = "author_username")
    private User author;

    private Long price;

    private String description;

    private boolean type;   //TODO: change this to something better

    @ManyToMany
    @JoinTable(
            name = "favourites",
            joinColumns = @JoinColumn(name = "offer_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private final Set<User> favourite = new HashSet<>();

    public Offer(Long id, User author, Long price, String description, boolean type) {
        this.id = id;
        this.author = author;
        this.price = price;
        this.description = description;
        this.type = type;
    }
}
