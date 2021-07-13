package app.services;

import app.dto.RequestDTO;
import app.dto.ResponseDTO;
import app.entities.AbstractEntity;
import app.mappers.CompleteMapper;
import app.repositories.LongKeyRepository;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * Абстрактный сервис с базовым CRUD-функционалом
 * @param <E> тип сущности, ограниченный {@link AbstractEntity}
 * @param <I> Incoming (Request) DTO - тип DTO-"запроса", ограниченный {@link RequestDTO}
 * @param <O> Outcoming (Response) DTO - тип DTO-"ответа", ограниченный {@link ResponseDTO}
 * @param <R> тип репоозитория, ограниченный {@link LongKeyRepository}
 * @param <M> тип маппера, ограниченный {@link CompleteMapper}
 *
 * @author Александров Илья
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public abstract class CRUDService<E extends AbstractEntity,
                                  I extends RequestDTO,
                                  O extends ResponseDTO,
                                  R extends LongKeyRepository<E>,
                                  M extends CompleteMapper<E, I, O>> implements AbstractService<I, O> {

    @Autowired
    protected R repository;

    @Autowired
    protected M mapper;

    /**
     *
     * @param dto объект RequestDTO, который конвертируется маппером
     *            и сохраняется репозиторием как сущность
     * @return объект ResponseDTO - представление созданной сущности
     */
    @Override
    public O create(I dto) {
        E createdEntity = repository.save(mapper.toEntity(dto));
        return mapper.toDto(createdEntity);
    }

    /**
     *
     * @param dto объект RequestDTO, который конвертируется маппером
     *            и обновляется репозиторием как сущность
     * @return объект ResponseDTO - представление "старой" сущности до обновления
     */
    @Override
    public O update(I dto) {
        E entityWithChanges = mapper.toEntity(dto);
        E oldEntity = repository.getOne(entityWithChanges.getId());
        mergeFieldsOnUpdate(oldEntity, entityWithChanges);
        repository.save(entityWithChanges);
        return mapper.toDto(oldEntity);
    }

    /**
     * При конвертации усеченных версий ResponseDTO в сущность
     * некоторые поля "новой" сущности заполняются значениями null.
     * При обновлении вместо них подставляются значения полей из "старой" сущности
     * @param oldEntity "старая" сущность, извлеченная из БД по id
     * @param entityWithChanges сущность с изменениями
     */
    protected void mergeFieldsOnUpdate(E oldEntity, E entityWithChanges) {
        try {
            for(Field f : entityWithChanges.getClass().getDeclaredFields()) {
                f.setAccessible(true);
                if (Objects.isNull(f.get(entityWithChanges))) {
                    f.set(entityWithChanges, oldEntity.getClass()
                                                        .getField(f.getName())
                                                        .get(oldEntity));
                }
            }
        } catch (IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dtoList список RequestDTO, который конвертируется маппером
     *                и сохраняется репозиторием как список сущностей
     * @return список ResponseDTO - представление сохраненных сущностей
     */
    @Override
    public List<O> saveAll(List<I> dtoList) {
        List<E> savedEntities = repository.saveAll(mapper.toEntityList(dtoList));
        return mapper.toDtoList(savedEntities);
    }

    /**
     *
     * @param dto RequestDTO с уникальным ключом id
     * @return Optional с результатом поиска в БД
     */
    @Override
    public Optional<O> find(I dto) {
        Long id = mapper.toEntity(dto).getId();
        return find(id);
    }

    /**
     *
     * @param id ключ, по которому осуществляется поиск сущности в БД
     * @return Optional с результатом поиска в БД
     */
    @Override
    public Optional<O> find(Long id) {
        O dto = mapper.toDto(repository.getOne(id));
        return Optional.of(dto);
    }

    /**
     *
     * @return объекты ResponseDTO - представление содержимого таблицы
     */
    @Override
    public List<O> findAll() {
        return mapper.toDtoList(repository.findAll());
    }

    /**
     *
     * @param dto RequestDTO с ключом, по которому сущность удаляется из БД
     */
    @Override
    public void delete(I dto) {
        repository.delete(mapper.toEntity(dto));
    }

    /**
     *
     * @param id ключ, по которому сущность удаляется из БД
     */
    @Override
    public void delete(Long id) {
        repository.delete(repository.getOne(id));
    }

    /**
     *
     * @param dto RequestDTO - представление сущности
     * @return есть ли сущность с заданным ключом в таблице
     */
    @Override
    public Boolean exists(I dto) {
        E entity = mapper.toEntity(dto);
        return repository.exists(Example.of(entity));
    }

    /**
     *
     * @param id ключ
     * @return есть ли сущность с заданным ключом в таблице
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
