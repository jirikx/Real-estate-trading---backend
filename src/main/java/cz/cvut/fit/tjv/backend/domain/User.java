package cz.cvut.fit.tjv.backend.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="app_users")
public class User implements CommonEntity<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String realName;
    private String email;
    @ManyToMany
    @JoinTable(
        name = "favourited_by_users",
        joinColumns = @JoinColumn(name = "user_id"),
        inverseJoinColumns = @JoinColumn(name = "offer_id")
    )
    Set<Offer> favouriteOffers;

    public User(Long id, String realName, String email) {
        this.id = id;
        this.realName = realName;
        this.email = email;
    }

    public User(String realName, String email) {
        this.realName = realName;
        this.email = email;
    }

    public User() {}

    @Override
    public Long getId() {
        return id;
    }

    public String getRealName() {
        return realName;
    }

    public String getEmail() {
        return email;
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

    public Set<Offer> getFavouriteOffers() {
        return favouriteOffers;
    }

    public void setFavouriteOffers(Set<Offer> favouriteOffers) {
        this.favouriteOffers = favouriteOffers;
    }

    public void addFavouriteOffer(Offer offer) {
        favouriteOffers.add(Objects.requireNonNull(offer));
    }

    public void removeFavouriteOffer(Offer offer) {
        favouriteOffers.remove(Objects.requireNonNull(offer));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return getId() != null ? getId().equals(user.getId()) : user.getId() == null;
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}
