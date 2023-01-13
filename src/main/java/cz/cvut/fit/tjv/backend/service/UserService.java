package cz.cvut.fit.tjv.backend.service;

import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.InformationPartRepository;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService extends CommonCrudService<User, Long> {
    private OfferRepository offerRepository;
    private InformationPartService informationPartService;
    public UserService(UserRepository userRepository, OfferRepository offerRepository, InformationPartService informationPartService) {
        super(userRepository);
        this.offerRepository = offerRepository;
        this.informationPartService = informationPartService;
    }

    public Collection<Offer> favouriteOffersFromUser(User user) {
        UserRepository userRepository = (UserRepository) crudRepository;
        return userRepository.favouriteOffersFromUser(user).stream().filter(Offer::isOpen).collect(Collectors.toSet());
    }

    @Transactional
    public void addFavouriteOffer(Long userId, Long offerId) {
        UserRepository userRepository = (UserRepository) crudRepository;
        User user = userRepository.findById(userId).orElseThrow();
        Offer offer = offerRepository.findById(offerId).orElseThrow();
        user.addFavouriteOffer(offer);
    }

    @Transactional
    public void removeFavouriteOffer(Long userId, Long offerId) {
        UserRepository userRepository = (UserRepository) crudRepository;
        User user = userRepository.findById(userId).orElseThrow();
        Offer offer = offerRepository.findById(offerId).orElseThrow();
        user.removeFavouriteOffer(offer);
        update(user);
    }

    public Collection<User> usersWhoSoldPropertiesInMoreThanGivenPriceInPrague(Long price) {
        Set<User> usersWhoSold = new HashSet<>();
        Map<User, Long> userToSum = new HashMap<>();
        char postalCodePrague = '1'; //Postal codes in Prague are in 1XX XX format

        Iterable<Offer> offerIterator = offerRepository.findAll();
        for (Offer o : offerIterator) {
            User u = o.getAuthor();
            if (o.getOfferInfo() != null && o.getOfferInfo().getPostalCode().toString().charAt(0) == postalCodePrague) {
                userToSum.put(u, userToSum.getOrDefault(u, 0L) + o.getPrice());
                if (userToSum.get(u) >= price)
                    usersWhoSold.add(u);
            }
        }

        return usersWhoSold;
    }

    public Long maximalId() {
        UserRepository userRepository = (UserRepository) crudRepository;
        return userRepository.maximalId();
    }
}
