package cz.cvut.fit.tjv.backend.repository;

import cz.cvut.fit.tjv.backend.domain.Offer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface OfferRepository extends CrudRepository<Offer, Long> {
    //public Collection<Offer> offersWithSimilarZipCode(@Param("zip_code") Long zipCode);
    @Query(value = "select max(id) as max_id from Offer")
    public Long maximalOfferId();
}
