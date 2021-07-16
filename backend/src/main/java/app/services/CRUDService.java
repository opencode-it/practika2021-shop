package app.services;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.entities.AbstractEntity;
import app.exceptions.FieldsMergerFailedException;
import app.mappers.RequestMapper;
import app.mappers.ResponseMapper;
import app.repositories.LongKeyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Абстрактный сервис с базовым CRUD-функционалом
 * @param <E> тип сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 * @param <R> тип репоозитория, ограниченный {@link LongKeyRepository}
 * @param <M> тип маппера, ограниченный {@link RequestMapper}
 * @param <N> тип маппера, органиченный {@link ResponseMapper}
 *
 * @author Александров Илья
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Log
public abstract class CRUDService<E extends AbstractEntity,
                                  I extends RequestDTO,
                                  O extends ResponseDTO,
                                  R extends LongKeyRepository<E>,
                                  M extends RequestMapper<E, I>,
                                  N extends ResponseMapper<E, O>>
                                    implements AbstractService<I, O> {

    @Autowired
    protected R repository;

    @Autowired
    protected M requestMapper;

    @Autowired
    protected N responseMapper;

    /**
     *
     * @param dto объект RequestDTO, который конвертируется маппером
     *            и сохраняется репозиторием как объект сущности
     * @return объект ResponseDTO - представление созданной сущности
     */
    @Override
    public O create(I dto) {
        E createdEntity = repository.save(requestMapper.toEntity(dto));
        return responseMapper.toDto(createdEntity);
    }

    /**
     *
     * @param dto объект RequestDTO, который конвертируется маппером
     *            и обновляется репозиторием как объект сущности
     * @return объект ResponseDTO - представление "старой" сущности до обновления
     */
    @Override
    public O update(I dto) {
        E entityWithChanges = requestMapper.toEntity(dto);
        E oldEntity = repository.getOne(entityWithChanges.getId());
        mergeFieldsOnUpdate(oldEntity, entityWithChanges);
        repository.save(entityWithChanges);
        return responseMapper.toDto(oldEntity);
    }

    /**
     * При конвертации усеченных версий ResponseDTO в сущность
     * некоторые поля нового объекта сущности заполняются значениями null.
     * При обновлении вместо них подставляются значения полей из старого объекта сущности
     * @param oldEntity старый объект сущности, извлеченный из БД по id
     * @param entityWithChanges объект сущности с изменениями
     */
    protected void mergeFieldsOnUpdate(E oldEntity, E entityWithChanges) {
        try {
            String fieldName;
            String setterName;
            String getterName;
            for(Field f : entityWithChanges.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Objects.isNull(f.get(entityWithChanges))) {
                    fieldName = f.getName();
                    setterName = "set"
                            .concat(fieldName.substring(0, 1).toUpperCase())
                            .concat(fieldName.substring(1));
                    getterName = setterName.replaceFirst("s", "g");
                    entityWithChanges
                            .getClass()
                            .getDeclaredMethod(setterName, f.getType())
                            .invoke(entityWithChanges, oldEntity
                                                        .getClass()
                                                        .getDeclaredMethod(getterName)
                                                        .invoke(oldEntity)
                            );
                }
            }
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            throw new FieldsMergerFailedException("Fields merger failed for "
                    .concat(entityWithChanges.toString()));
        }
    }

    /**
     *
     * @param dtoList список RequestDTO, который конвертируется маппером
     *                и сохраняется репозиторием как список объектов сущности
     * @return список ResponseDTO - представление сохраненных объектов сущности
     */
    @Override
    public List<O> saveAll(List<I> dtoList) {
        List<E> savedEntities = repository.saveAll(requestMapper.toEntityList(dtoList));
        return responseMapper.toDtoList(savedEntities);
    }

    /**
     *
     * @param dto RequestDTO с уникальным ключом id
     * @return Optional с результатом поиска в БД
     */
    @Override
    public Optional<O> find(I dto) {
        Long id = requestMapper.toEntity(dto).getId();
        return find(id);
    }

    /**
     *
     * @param id ключ, по которому осуществляется поиск объекта сущности в БД
     * @return Optional с результатом поиска в БД
     */
    @Override
    public Optional<O> find(Long id) {
        O dto = responseMapper.toDto(repository.getOne(id));
        return Optional.of(dto);
    }

    /**
     *
     * @return объекты ResponseDTO - представление содержимого таблицы
     */
    @Override
    public List<O> findAll() {
        return responseMapper.toDtoList(repository.findAll());
    }

    /**
     *
     * @param idList - список ключей
     * @return объекты ResponseDTO - представление содержимого таблицы
     */
    @Override
    public List<O> findAllById(List<Long> idList) {
        return responseMapper.toDtoList(repository.findAllById(idList));
    }

    /**
     *
     * @param dto RequestDTO с ключом, по которому объект сущности удаляется из БД
     */
    @Override
    public void delete(I dto) {
        repository.delete(requestMapper.toEntity(dto));
    }

    /**
     *
     * @param id ключ, по которому объект сущности удаляется из БД
     */
    @Override
    public void delete(Long id) {
        repository.delete(repository.getOne(id));
    }

    /**
     *
     * @param dto RequestDTO - представление сущности
     * @return есть ли объект сущности с заданным ключом в таблице
     */
    @Override
    public Boolean exists(I dto) {
        E entity = requestMapper.toEntity(dto);
        return repository.exists(Example.of(entity));
    }

    /**
     *
     * @param id ключ
     * @return есть ли объект сущности с заданным ключом в таблице
     */
    @Override
    public Boolean exists(Long id) {
        return repository.existsById(id);
    }

    /**
     *
     * @return размер таблицы
     */
    @Override
    public Long count() {
        return repository.count();
    }
}
