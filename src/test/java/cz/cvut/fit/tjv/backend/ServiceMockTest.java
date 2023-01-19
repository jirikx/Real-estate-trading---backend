package cz.cvut.fit.tjv.backend;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class ServiceMockTest {
    @Autowired
    private UserService userService;
    @Autowired
    private OfferService offerService;
    @MockBean
    private OfferRepository offerRepository;
    @Test
    void usersWhoSoldPropertiesInMoreThanGivenPriceInPragueTest() {
        User u = new User(1L, "Tom", "tom@email.cz");
        Offer o = new Offer(1L, u, 1000000L);
        InformationPart i = new InformationPart(o);
        i.setPostalCode(11500L);
        o.setOfferInfo(i);

        Mockito.when(offerRepository.findAll()).thenReturn(List.of(o));
        var col = userService.usersWhoSoldPropertiesInMoreThanGivenPriceInPrague(999L);
        assertEquals(col.size(), 1);
        assertEquals(col.iterator().next().getRealName(), o.getAuthor().getRealName());
    }
}
