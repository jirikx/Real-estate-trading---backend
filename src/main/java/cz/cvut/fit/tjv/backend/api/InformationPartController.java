package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.InformationPartDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.InformationPartMapper;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import cz.cvut.fit.tjv.backend.service.OfferService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityExistsException;
import java.net.URI;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("${apiPrefix}/infoparts")
public class InformationPartController extends CommonCrudController<InformationPart, InformationPartDto, Long> {
    OfferService offerService;

    public InformationPartController(InformationPartService informationPartService, InformationPartMapper informationPartMapper, OfferService offerService) {
        super(informationPartService, informationPartMapper);
        this.offerService = offerService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Override
    public Long create(@RequestBody InformationPartDto dto) {
        try {
            InformationPart informationPart = mapper.toEntity(dto);
            offerService.readById(dto.getOffer()).setOfferInfo(informationPart);    //Check if offer exists and update its information part
            return service.create(informationPart).getUri();
        } catch (EntityExistsException | NoSuchElementException e ) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't create this entity.");
        }
    }
}
