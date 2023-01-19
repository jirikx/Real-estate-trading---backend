package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.InformationPartDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.InformationPartMapper;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.sql.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserComplexQueryTest {
    @Autowired
    private UserController userController;
    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;
    @Autowired
    private InformationPartService informationPartService;
    @Test
    public void testComplexQuery() {
        User user = new User("Honza", "honza@email.cz");
        Offer cheap = new Offer(user, 999800L);
        Offer expensive = new Offer(user, 19000500L);
        InformationPart info = new InformationPart(expensive, new Date(2022, 12, 31), "Karlova", 16000L, new Date(2023, 5, 30), 80L);
        expensive.setOfferInfo(info);

        userService.create(user);
        offerService.create(cheap);

        var created = offerService.create(expensive);
        offerService.readById(created.getId()).setOfferInfo(info);
        informationPartService.create(info);

        assertEquals(offerService.readById(offerService.maximalOfferId()).getOfferInfo(), informationPartService.readAll().iterator().next());
        assertEquals(userService.readAll().iterator().next(), offerService.readAll().iterator().next().getAuthor());
        assertEquals("Karlova", informationPartService.readAll().iterator().next().getStreet());
    }
}

