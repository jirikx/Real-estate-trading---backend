package cz.cvut.fit.tjv.backend.api;


import cz.cvut.fit.tjv.backend.api.dto.UserDto;
import cz.cvut.fit.tjv.backend.api.dto.mapper.CommonMapper;
import cz.cvut.fit.tjv.backend.domain.CommonEntity;
import cz.cvut.fit.tjv.backend.service.CommonCrudService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public abstract class CommonCrudController<Entity extends CommonEntity<ID>, Dto, ID> {
    private CommonCrudService<Entity, ID> service;
    private CommonMapper<Entity, Dto> mapper;

    public CommonCrudController(CommonCrudService<Entity, ID> service, CommonMapper<Entity, Dto> mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody Dto dto) throws URISyntaxException {
        try {
            service.create(mapper.toEntity(dto));
        } catch (EntityExistsException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Can't create duplicated entity.");
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Dto read(@PathVariable ID id) {
        try {
            Entity entity = service.readById(id);
            return mapper.toDto(entity);
        } catch (NoSuchElementException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Entity with given id wasn't found.");
        }
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public Collection<Dto> readAll() {
        return service.readAll().stream().map(mapper::toDto).collect(Collectors.toSet());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@RequestBody Dto dto, @PathVariable ID id) throws URISyntaxException {
        try {
            service.update(mapper.toEntity(dto));
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't update nonexistent entity.");
        }
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable ID id) {
        try {
            service.delete(id);
        } catch (EntityNotFoundException e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't delete nonexistent entity.");
        }
    }
}
