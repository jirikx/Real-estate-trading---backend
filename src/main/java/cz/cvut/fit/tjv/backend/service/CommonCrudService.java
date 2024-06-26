package cz.cvut.fit.tjv.backend.service;

import cz.cvut.fit.tjv.backend.domain.CommonEntity;
import org.springframework.data.repository.CrudRepository;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.NoSuchElementException;

/**
 * Common class for CRUD operations with entities
 * @param <Entity>
 * @param <Key>
 */
public abstract class CommonCrudService<Entity extends CommonEntity<Key>, Key> {
    protected final CrudRepository<Entity, Key> crudRepository;

    public CommonCrudService(CrudRepository<Entity, Key> crudRepository) {
        this.crudRepository = crudRepository;
    }

    public Entity create(Entity entity) {
        return crudRepository.save(entity);
    }

    public Entity readById(Key id) {
        return crudRepository.findById(id).orElseThrow();
    }

    public Collection<Entity> readAll() {
        return (Collection<Entity>) crudRepository.findAll();
    }

    public Entity update(Entity entity) {
        if (!crudRepository.existsById(entity.getId()))
            throw new EntityNotFoundException();
        return crudRepository.save(entity);
    }

    public void delete(Key id) {
        if (!crudRepository.existsById(id))
            throw new EntityNotFoundException();
        crudRepository.deleteById(id);
    }
}
