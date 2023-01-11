package cz.cvut.fit.tjv.backend.repository;

import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    @Query(value = "select o from Offer o where :user_id member of o.favouritedBy")
    Collection<Offer> favouriteOffersFromUser(@Param("user_id") User user);
}
