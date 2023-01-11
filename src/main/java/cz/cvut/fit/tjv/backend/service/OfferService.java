package cz.cvut.fit.tjv.backend.service;

import cz.cvut.fit.tjv.backend.api.dto.OfferDto;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class OfferService extends CommonCrudService<Offer, Long> {
    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
    }

    /*public Collection<Offer> offersWithSimilarZipCode(Long zipCode) {
        return new HashSet<Offer>();//TODO
    }*/

    /**
     * OfferService gives only opened offers by default
     * @return
     */
    @Override
    public Collection<Offer> readAll() {
        Iterable<Offer> it = crudRepository.findAll();
        return StreamSupport.stream(it.spliterator(), false).filter(Offer::isOpen).collect(Collectors.toSet());
    }
}
