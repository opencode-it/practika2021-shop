package app.services;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;

import java.util.List;
import java.util.Optional;

/**
 * Интерфейс, определяющий базовый контракт для сервисов
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 *
 * @author Александров Илья
 */
public interface AbstractService<I extends RequestDTO, O extends ResponseDTO> {

    O create(I dto);
    O update(I dto);
    List<O> saveAll(List<I> dtoList);
    Optional<O> find(I dto);
    Optional<O> find(Long id);
    List<O> findAll();
    List<O> findAllById(List<Long> idList);
    void delete(I dto);
    void delete(Long id);
    Boolean exists(I dto);
    Boolean exists(Long id);
    Long count();
}

