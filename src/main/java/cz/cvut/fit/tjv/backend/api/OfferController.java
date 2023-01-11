package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.OfferMapper;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("${apiPrefix}/offers")
public class OfferController extends CommonCrudController<Offer, OfferDto, Long> {
    UserService userService;

    public OfferController(OfferService offerService, OfferMapper offerMapper, UserService userService) {
        super(offerService, offerMapper);
        this.userService = userService;
    }
}
