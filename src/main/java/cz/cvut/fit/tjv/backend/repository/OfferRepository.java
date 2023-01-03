package cz.cvut.fit.tjv.backend.repository;

import cz.cvut.fit.tjv.backend.domain.Offer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
}
