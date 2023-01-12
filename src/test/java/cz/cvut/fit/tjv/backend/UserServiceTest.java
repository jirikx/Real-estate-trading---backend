package cz.cvut.fit.tjv.backend;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    UserService userService;
    @Autowired
    OfferService offerService;

    @Test
    void addFavouriteOfferTest() {
        User author = new User("Autor Nabidky", "autor@nabidky.cz");
        User t = new User("Prokop Novak", "prokop@yahoo.com");
        Offer toLike = new Offer(author, 999L);

        author = userService.create(author);
        t = userService.create(t);
        assertEquals(userService.readById(1L), author);
        assertEquals(userService.readById(2L), t);

        toLike = offerService.create(toLike);
        assertEquals(offerService.readById(offerService.maximalOfferId()), toLike);

        userService.addFavouriteOffer(t.getId(), toLike.getId());
        assertEquals(userService.favouriteOffersFromUser(t).size(), 1);
        userService.removeFavouriteOffer(t.getId(), toLike.getId());
        assertEquals(userService.favouriteOffersFromUser(t).size(), 0);
    }
}
