package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

@Entity
@Table(name="app_users")
public class User implements CommonEntity<Long> {
    @Id
    @GeneratedValue
    private Long id;
    private String realName;
    private String email;
    @OneToMany(mappedBy = "author")
    private Collection<Offer> myOpenOffers;
    @OneToMany(mappedBy = "author")
    private Collection<Offer> myClosedOffers;
    @ManyToMany(mappedBy = "favouritedBy")
    private Set<Offer> favouriteOffers;

    public User(String realName, String email) {
        this.realName = realName;
        this.email = email;
    }

    public User() {}

    @Override
    public Long getId() {
        return id;
    }

    public boolean addOfferToFavs(Offer offer) {
        return favouriteOffers.add(offer);
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
    }

    public Collection<Offer> getMyOpenOffers() {
        return myOpenOffers;
    }

    public Collection<Offer> getMyClosedOffers() {
        return myClosedOffers;
    }

    public Set<Offer> getFavouriteOffers() {
        return favouriteOffers;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMyOpenOffers(Collection<Offer> myOpenOffers) {
        this.myOpenOffers = myOpenOffers;
    }

    public void setMyClosedOffers(Collection<Offer> myClosedOffers) {
        this.myClosedOffers = myClosedOffers;
    }

    public void setFavouriteOffers(Set<Offer> favouriteOffers) {
        this.favouriteOffers = favouriteOffers;
    }
}
