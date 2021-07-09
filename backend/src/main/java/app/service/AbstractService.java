package app.service;

import app.dto.AbstractDto;
import app.entities.AbstractEntity;
import app.mapper.AbstractMapper;
import app.repository.LongKeyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Data
@AllArgsConstructor
public abstract class AbstractService<E extends AbstractEntity,
                                      D extends AbstractDto,
                                      R extends LongKeyRepository<E>,
                                      M extends AbstractMapper<E, D>> {

    private R repository;

    private M mapper;

    public D save(D dto) {
        E savedEntity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(savedEntity);
    }

    public List<D> saveAll(List<D> dtoList) {
        List<E> savedEntities = repository.saveAll(mapper.toEntityList(dtoList));
        return mapper.toDtoList(savedEntities);
    }

    public D findBy(Long id) {
        return mapper.toDto(repository.getOne(id));
    }

    public List<D> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    public void deleteBy(Long id) {
        repository.delete(repository.getOne(id));
    }

    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    public Long count() {
        return repository.count();
    }
}
