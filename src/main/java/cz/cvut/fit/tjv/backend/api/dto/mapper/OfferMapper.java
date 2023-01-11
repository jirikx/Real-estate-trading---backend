package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import cz.cvut.fit.tjv.backend.service.UserService;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class OfferMapper implements CommonMapper<Offer, OfferDto> {
    private final UserService userService;
    private final InformationPartService informationPartService;

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
        if (offer.getOfferInfo() != null)
            offerDto.setOfferInfo(offer.getOfferInfo().getUri());

        return offerDto;
    }

    public Offer toEntity(OfferDto offerDto) {
        Offer offer;
        if (offerDto.getId() == null)
            offer = new Offer(userService.readById(offerDto.getAuthor()), offerDto.getPrice());
        else
            offer = new Offer(offerDto.getId(), userService.readById(offerDto.getAuthor()), offerDto.getPrice());

        offer.setClosed(offerDto.isClosed());
        offer.setOfferType(offerDto.getOfferType());
        offer.setFavouritedBy(offerDto.getFavouritedBy().stream().map(userService::readById).collect(Collectors.toSet()));
        if (offerDto.getOfferInfo() != null)
            offer.setOfferInfo(informationPartService.readById(offerDto.getOfferInfo()));

        return offer;
    }
}
