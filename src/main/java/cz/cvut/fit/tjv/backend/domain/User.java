package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name="users_table")
public class User {
    @Id
    private Long id;

    @Column(name="real_name")
    private String realName;

    private String email;

    @OneToMany(mappedBy = "author")
    private Collection<Offer> myOffers;

    public User(Long id, String realName, String email, Collection<Offer> myOffers) {
        this.id = id;
        this.realName = realName;
        this.email = email;
        this.myOffers = myOffers;
    }
}
