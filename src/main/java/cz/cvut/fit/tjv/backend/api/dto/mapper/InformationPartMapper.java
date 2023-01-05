package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.InformationPartDto;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.net.URISyntaxException;
import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

@Component
public class InformationPartMapper {
    public InformationPartDto toDto(InformationPart informationPart) {
        InformationPartDto informationPartDto = new InformationPartDto();
        informationPartDto.setUri(informationPart.getUri().toString());
        informationPartDto.setCreationTime(informationPart.getCreationTime().toString());
        informationPartDto.setStreet(informationPart.getStreet());
        informationPartDto.setPostalCode(informationPart.getPostalCode());
        informationPartDto.setMoveInDate(informationPart.getMoveInDate().toString());
        informationPartDto.setAcreage(informationPart.getAcreage());

        return informationPartDto;
    }

    public InformationPart toEntity(InformationPartDto informationPartDto) throws URISyntaxException {
        InformationPart informationPart = new InformationPart(new URI(informationPartDto.getUri()));
        informationPart.setCreationTime(Date.valueOf(informationPartDto.getCreationTime()));
        informationPart.setStreet(informationPartDto.getStreet());
        informationPart.setPostalCode(informationPartDto.getPostalCode());
        informationPart.setMoveInDate(Date.valueOf(informationPartDto.getMoveInDate()));
        informationPart.setAcreage(informationPartDto.getAcreage());

        return informationPart;
    }
}
