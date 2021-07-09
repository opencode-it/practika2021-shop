package app.mapper;

import app.dto.AbstractDto;
import app.entities.AbstractEntity;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper
public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);
    List<E> toEntityList(List<D> dtoList);
    D toDto(E entity);
    List<D> toDtoList(List<E> entityList);
}
