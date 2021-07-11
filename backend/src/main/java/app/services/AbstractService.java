package app.services;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.entities.AbstractEntity;
import app.mappers.AbstractMapper;
import app.repositories.LongKeyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Абстрактный сервис с базовым CRUD-функционалом
 * @param <E> тип сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 * @param <R> тип репоозитория, ограниченный {@link LongKeyRepository}
 * @param <M> тип маппера, ограниченный {@link AbstractMapper}
 *
 * @author Александров Илья
 */
@Service
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class AbstractService<E extends AbstractEntity,
                                      I extends RequestDTO,
                                      O extends ResponseDTO,
                                      R extends LongKeyRepository<E>,
                                      M extends AbstractMapper<E, I, O>> {

    @Autowired
    R repository;

    @Autowired
    M mapper;

    /**
     *
     * @param dto объект DTO, который конвертируется маппером
     *            и сохраняется репозиторием как сущность
     * @return объект DTO - представление сохраненной сущности
     */
    public O save(I dto) {
        E savedEntity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(savedEntity);
    }

    /**
     *
     * @param dtoList список DTO, который конвертируется маппером
     *                и сохраняется репозиторием как список сущностей
     * @return список DTO - представление сохраненных сущностей
     */
    public List<O> saveAll(List<I> dtoList) {
        List<E> savedEntities = repository.saveAll(mapper.toEntityList(dtoList));
        return mapper.toDtoList(savedEntities);
    }

    /**
     *
     * @param id ключ, по которому осуществляется поиск сущности в БД
     * @return Optional с результатом поиска в БД
     */
    public Optional<O> findBy(Long id) {
        O dto = mapper.toDto(repository.getOne(id));
        return Optional.of(dto);
    }

    /**
     *
     * @return объекты DTO - представление содержимого таблицы
     */
    public List<O> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    /**
     *
     * @param id ключ, по которому сущность удаляется из БД
     */
    public void deleteBy(Long id) {
        repository.delete(repository.getOne(id));
    }

    /**
     *
     * @param id ключ
     * @return есть ли сущность с заданным ключом в таблице
     */
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    /**
     *
     * @return размер таблицы
     */
    public Long count() {
        return repository.count();
    }
}
