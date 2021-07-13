package app.mappers;

import app.dto.RequestDTO;
import app.entities.AbstractEntity;

import java.util.List;

/**
 * Определяет контракт для конвертации из DTO в сущность
 * на уровне отдельных объектов и списков
 * @param <E> тип преобразуемой сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 *
 * @author Александров Илья
 */
public interface RequestMapper<E extends AbstractEntity, I extends RequestDTO> {

    E toEntity(I dto);
    List<E> toEntityList(List<I> dtoList);
}
