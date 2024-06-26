package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.OfferMapper;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.service.OfferService;
import cz.cvut.fit.tjv.backend.service.UserService;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.util.Collection;
import java.util.HashSet;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("${apiPrefix}/offers")
public class OfferController extends CommonCrudController<Offer, OfferDto, Long> {
    UserService userService;

    public OfferController(OfferService offerService, OfferMapper offerMapper, UserService userService) {
        super(offerService, offerMapper);
        this.userService = userService;
    }

    public Collection<OfferDto> similarOffers(OfferDto customerOffer) {
        return new HashSet<OfferDto>();//TODO
    }

    @PutMapping("/close/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Set state of given offer to CLOSED")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully changed the offer state"),
        @ApiResponse(responseCode = "404", description = "Can't close nonexistent offer"),
    })
    public void closeOffer(@PathVariable Long id) {
        try {
            Offer closeOffer = service.readById(id);
            closeOffer.setClosed(true);
            service.update(closeOffer);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't close nonexistent offer.");
        }
    }

    @PutMapping("/open/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Set state of given offer to OPEN")
    @ApiResponses(value = {
        @ApiResponse(responseCode = "200", description = "Successfully changed the offer state"),
        @ApiResponse(responseCode = "404", description = "Can't open nonexistent offer"),
    })
    public void openOffer(@PathVariable Long id) {
        try {
            Offer openOffer = service.readById(id);
            openOffer.setClosed(false);
            service.update(openOffer);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't open nonexistent offer.");
        }
    }

    @GetMapping("/max")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get maximal offer ID in the database")
    public Long maximalOfferId() {
        OfferService offerService = (OfferService) service;
        return offerService.maximalOfferId();
    }
}
