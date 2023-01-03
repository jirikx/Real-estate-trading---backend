package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;

@Entity
@Table(name="app_users")
public class User implements Serializable {
    @Id
    private Long id;
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

    public User() {}
}
