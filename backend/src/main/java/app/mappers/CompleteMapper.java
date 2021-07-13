package app.mappers;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.entities.AbstractEntity;

/**
 * Определяет контракт для полноценного двунаправленного маппера
 * @param <E> тип преобразуемой сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 *
 * @author Александров Илья
 */
public interface CompleteMapper<E extends AbstractEntity,
                                I extends RequestDTO,
                                O extends ResponseDTO> extends ToEntityMapper<E, I>, ToDtoMapper<E, O> {

}
