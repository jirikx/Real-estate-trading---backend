package cz.cvut.fit.tjv.backend.business;

import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.OfferRepository;
import org.springframework.stereotype.Service;

@Service
public class OfferService extends CommonCrudService<Offer, Long> {
    public OfferService(OfferRepository offerRepository) {
        super(offerRepository);
    }
}
