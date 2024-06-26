package cz.cvut.fit.tjv.backend.api.dto;

import cz.cvut.fit.tjv.backend.domain.Offer;
import java.util.Collection;
import java.util.Set;

public class UserDto {
    private Long id;
    private String realName;
    private String email;
    private Set<Long> favouriteOffers;

    public UserDto(Long id, String realName, String email, Collection<Long> myOffers, Set<Long> favouriteOffers) {
        this.id = id;
        this.realName = realName;
        this.email = email;
        this.favouriteOffers = favouriteOffers;
    }

    public UserDto(Long id, String realName, String email) {
        this.id = id;
        this.realName = realName;
        this.email = email;
    }

    public UserDto(Long id, String realName, String email, Collection<Long> myOffers) {
        this.id = id;
        this.realName = realName;
        this.email = email;
    }

    public UserDto(String realName, String email) {
        this.realName = realName;
        this.email = email;
    }

    public UserDto(String realName, String email, Collection<Long> myOffers) {
        this.realName = realName;
        this.email = email;
    }

    public UserDto() {}

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

    public Set<Long> getFavouriteOffers() {
        return favouriteOffers;
    }

    public void setFavouriteOffers(Set<Long> favouriteOffers) {
        this.favouriteOffers = favouriteOffers;
    }
}
