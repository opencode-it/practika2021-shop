package app.mapper;

import app.dto.AbstractDto;
import app.entities.AbstractEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Маппер. Осуществляет конвертацию сущность-DTO на уровне отдельных объектов и списков
 * @param <E> тип преобазуемой сущности, ограниченный {@link AbstractEntity}
 * @param <D> тип DTO, ограниченный {@link AbstractDto}
 *
 * @author Александров Илья
 */
@Mapper
public interface AbstractMapper<E extends AbstractEntity, D extends AbstractDto> {

    E toEntity(D dto);
    List<E> toEntityList(List<D> dtoList);
    D toDto(E entity);
    List<D> toDtoList(List<E> entityList);
}
