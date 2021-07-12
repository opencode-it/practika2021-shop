package app.mappers;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.entities.AbstractEntity;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Абстрактный маппер. Осуществляет конвертацию сущность-DTO на уровне отдельных объектов и списков
 * @param <E> тип преобразуемой сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 *
 * @author Александров Илья
 */
public interface AbstractMapper<E extends AbstractEntity,
                                I extends RequestDTO,
                                O extends ResponseDTO> {

    E toEntity(I dto);
    List<E> toEntityList(List<I> dtoList);
    O toDto(E entity);
    List<O> toDtoList(List<E> entityList);
}
