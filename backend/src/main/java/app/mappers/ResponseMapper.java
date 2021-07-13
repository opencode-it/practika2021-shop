package app.mappers;

import app.dto.ResponseDTO;
import app.entities.AbstractEntity;

import java.util.List;

/**
 * Определяет контракт для конвертации из сущности в DTO
 * на уровне отдельных объектов и списков
 * @param <E> тип преобразуемой сущности, ограниченный {@link AbstractEntity}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 *
 * @author Александров Илья
 */
public interface ResponseMapper<E extends AbstractEntity, O extends ResponseDTO> {

    O toDto(E entity);
    List<O> toDtoList(List<E> entityList);
}
