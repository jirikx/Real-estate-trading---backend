package cz.cvut.fit.tjv.backend.api;

import cz.cvut.fit.tjv.backend.api.dto.InformationPartDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.InformationPartMapper;
import cz.cvut.fit.tjv.backend.domain.InformationPart;
import cz.cvut.fit.tjv.backend.service.InformationPartService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;

@RestController
@RequestMapping("${apiPrefix}/infopart")
public class InformationPartController extends CommonCrudController<InformationPart, InformationPartDto, URI> {
    public InformationPartController(InformationPartService informationPartService, InformationPartMapper informationPartMapper) {
        super(informationPartService, informationPartMapper);
    }
}
