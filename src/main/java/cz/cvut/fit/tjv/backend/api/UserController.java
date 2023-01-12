package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.OfferMapper;
import cz.cvut.fit.tjv.backend.api.dto.mapper.UserMapper;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@RestController
@RequestMapping("${apiPrefix}/users")
public class UserController extends CommonCrudController<User, UserDto, Long> {
    private final OfferMapper offerMapper;

    public UserController(UserService service, UserMapper mapper, OfferMapper offerMapper) {
        super(service, mapper);
        this.offerMapper = offerMapper;
    }

    @PostMapping("/{userId}/favs/{offerId}")
    @ResponseStatus(HttpStatus.CREATED)
    public void addFavouriteOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        try {
            UserService userService = (UserService) service;
            userService.addFavouriteOffer(userId, offerId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User or offer doesn't exist.");
        }
    }

    @DeleteMapping("/{userId}/favs/{offerId}")
    @ResponseStatus(HttpStatus.OK)
    public void removeFavouriteOffer(@PathVariable Long userId, @PathVariable Long offerId) {
        try {
            UserService userService = (UserService) service;
            userService.removeFavouriteOffer(userId, offerId);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User or offer doesn't exist.");
        }
    }

    @GetMapping("/{userId}/favs")
    @ResponseStatus(HttpStatus.OK)
    public List<OfferDto> readFavouritesFromUser(@PathVariable Long userId) {
        try {
            UserService userService = (UserService) service;
            User user = userService.readById(userId);
            return userService.favouriteOffersFromUser(user).stream().map(offerMapper::toDto).collect(Collectors.toList());
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't return favourite offers from nonexistent user.");
        }
    }

    @GetMapping("/rich")
    @ResponseStatus(HttpStatus.OK)
    public List<UserDto> readRichUsers() {
        UserService userService = (UserService) service;
        return userService.usersWhoSoldPropertiesInMoreThanGivenPriceInPrague(20000000L).stream().map(mapper::toDto).collect(Collectors.toList());
    }


}
