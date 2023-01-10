package cz.cvut.fit.tjv.backend.api.dto.mapper;

import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.domain.Offer;
import cz.cvut.fit.tjv.backend.domain.User;

import java.net.URISyntaxException;
import java.util.stream.Collectors;

public interface CommonMapper<Entity, Dto> {
    public Dto toDto (Entity entity);

    public Entity toEntity(Dto dto) throws URISyntaxException;
}
