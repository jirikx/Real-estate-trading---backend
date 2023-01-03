package cz.cvut.fit.tjv.backend.business;

import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.domain.User;
import cz.cvut.fit.tjv.backend.repository.InformationPartRepository;
import org.springframework.stereotype.Service;

import java.net.URI;

@Service
public class InformationPartService extends CommonCrudService<InformationPart, URI> {
    public InformationPartService (InformationPartRepository informationPartRepository) {
        super(informationPartRepository);
    }
}