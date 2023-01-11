package cz.cvut.fit.tjv.backend.service;

import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;

@Service
public class UserService extends CommonCrudService<User, Long> {
    private OfferRepository offerRepository;
    public UserService(UserRepository userRepository, OfferRepository offerRepository) {
        super(userRepository);
        this.offerRepository = offerRepository;
    }

    public Collection<Offer> favouriteOffersFromUser(User user) {
        UserRepository userRepository = (UserRepository) crudRepository;
        return userRepository.favouriteOffersFromUser(user);
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
    }
}
