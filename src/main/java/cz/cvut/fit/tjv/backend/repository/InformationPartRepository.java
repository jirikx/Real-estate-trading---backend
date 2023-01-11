package cz.cvut.fit.tjv.backend.repository;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.net.URI;

@Repository
public interface InformationPartRepository extends CrudRepository<InformationPart, Long> {
}
