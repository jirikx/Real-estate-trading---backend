package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.InformationPartDto;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.service.OfferService;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;

@Component
public class InformationPartMapper implements CommonMapper<InformationPart, InformationPartDto> {
    OfferService offerService;

    public InformationPartMapper(OfferService offerService) {
        this.offerService = offerService;
    }
    public InformationPartDto toDto(InformationPart informationPart) {
        InformationPartDto informationPartDto = new InformationPartDto();
        informationPartDto.setUri(informationPart.getUri());
        informationPartDto.setOffer(informationPart.getOffer().getId());
        informationPartDto.setCreationTime(informationPart.getCreationTime().toString());
        informationPartDto.setStreet(informationPart.getStreet());
        informationPartDto.setPostalCode(informationPart.getPostalCode());
        informationPartDto.setMoveInDate(informationPart.getMoveInDate().toString());
        informationPartDto.setAcreage(informationPart.getAcreage());

        return informationPartDto;
    }

    public InformationPart toEntity(InformationPartDto informationPartDto) {
        InformationPart informationPart;
        if (informationPartDto.getUri() == null)
            informationPart = new InformationPart(offerService.readById(informationPartDto.getOffer()));
        else
            informationPart = new InformationPart(informationPartDto.getUri(), offerService.readById(informationPartDto.getOffer()));

        informationPart.setCreationTime(Date.valueOf(informationPartDto.getCreationTime()));
        informationPart.setStreet(informationPartDto.getStreet());
        informationPart.setPostalCode(informationPartDto.getPostalCode());
        informationPart.setMoveInDate(Date.valueOf(informationPartDto.getMoveInDate()));
        informationPart.setAcreage(informationPartDto.getAcreage());

        return informationPart;
    }
}
