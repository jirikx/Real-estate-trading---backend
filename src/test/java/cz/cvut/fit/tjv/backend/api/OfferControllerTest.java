package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.repository.UserRepository;
import cz.cvut.fit.tjv.backend.service.OfferService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class OfferControllerTest {
    @Autowired
    OfferController offerController;
    @Autowired
    UserController userController;

    @Test
    void closeOffer() {
        UserDto u = new UserDto();
        u.setRealName("Josef Vomacka");
        u.setEmail("jozka@email.cz");
        var userId = userController.create(u);

        OfferDto t = new OfferDto();
        t.setAuthor(userId);
        t.setPrice(42999L);
        var offerId = offerController.create(t);

        offerController.closeOffer(offerId);
        assertEquals(offerController.readAll().size(), 0);
    }
}
