package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.OfferType;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class OfferMapper {
    private UserService userService;
    private InformationPartService informationPartService;

    public OfferMapper(UserService userService, InformationPartService informationPartService) {
        this.userService = userService;
        this.informationPartService = informationPartService;
    }

    public OfferDto toDto(Offer offer) {
        OfferDto offerDto = new OfferDto();
        offerDto.setId(offer.getId());
        offerDto.setAuthor(offer.getAuthor().getId());
        offerDto.setPrice(offer.getPrice());
        offerDto.setClosed(offerDto.isClosed());
        offerDto.setOfferType(offer.getOfferType());
        offerDto.setFavouritedBy(offer.getFavouritedBy().stream().map(User::getId).collect(Collectors.toSet()));    //TODO: test this
        offerDto.setOfferInfo(offer.getOfferInfo().getId().toString());

        return offerDto;
    }

    private Offer toEntity(OfferDto offerDto) throws URISyntaxException {
        Offer offer = new Offer(offerDto.getId(), userService.readById(offerDto.getId()), offerDto.getPrice());
        offer.setClosed(offerDto.isClosed());
        offer.setOfferType(offerDto.getOfferType());
        offer.setFavouritedBy(offerDto.getFavouritedBy().stream().map(userService::readById).collect(Collectors.toSet()));
        offer.setOfferInfo(informationPartService.readById(new URI(offerDto.getOfferInfo())));

        return offer;
    }
}
