package app.mappers;

import app.controllers.dto.DTO;
import app.entities.AbstractEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Маппер. Осуществляет конвертацию сущность-DTO на уровне отдельных объектов и списков
 * @param <E> тип преобазуемой сущности, ограниченный {@link AbstractEntity}
 * @param <D> тип DTO, ограниченный {@link DTO}
 *
 * @author Александров Илья
 */
@Mapper
public interface AbstractMapper<E extends AbstractEntity, D extends DTO> {

    E toEntity(D dto);
    List<E> toEntityList(List<D> dtoList);
    D toDto(E entity);
    List<D> toDtoList(List<E> entityList);
}
