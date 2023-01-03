package cz.cvut.fit.tjv.backend.api.dto;

import cz.cvut.fit.tjv.backend.domain.Offer;
import java.util.Collection;
import java.util.Set;

public class UserDto {
    private Long id;
    private String realName;
    private String email;
    private Collection<Long> myOffers;
    private Set<Long> favouriteOffers;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Collection<Long> getMyOffers() {
        return myOffers;
    }

    public void setMyOffers(Collection<Long> myOffers) {
        this.myOffers = myOffers;
    }

    public Set<Long> getFavouriteOffers() {
        return favouriteOffers;
    }

    public void setFavouriteOffers(Set<Long> favouriteOffers) {
        this.favouriteOffers = favouriteOffers;
    }
}
