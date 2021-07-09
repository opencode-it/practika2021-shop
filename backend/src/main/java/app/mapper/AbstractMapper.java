package app.mapper;

import app.dto.AbstractDto;
import app.entities.AbstractEntity;

import java.util.List;

public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);
    List<E> toEntityList(List<D> dtoList);
    D toDto(E entity);
    List<D> toDtoList(List<E> entityList);
}
