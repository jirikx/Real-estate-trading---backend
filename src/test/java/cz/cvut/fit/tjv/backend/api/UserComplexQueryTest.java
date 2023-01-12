package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
public class UserComplexQueryTest {
    @Autowired
    UserController userController;
    @Autowired
    UserService userService;
    @Autowired
    OfferService offerService;
    @Autowired
    InformationPartService informationPartService;
    @Test
    public void testComplexQuery() {
        User user = new User("Honza", "honza@email.cz");
        InformationPart info = new InformationPart(1L, new Date(2022, 12, 31), "Karlova", 16000L, new Date(2023, 5, 30), 80L);
        Offer cheap = new Offer(user, 999800L);
        Offer expensive = new Offer(user, 19000500L);
        info.setOffer(expensive);

        userService.create(user);
        offerService.create(cheap);
        offerService.create(expensive);
        informationPartService.create(info);
    }
}
