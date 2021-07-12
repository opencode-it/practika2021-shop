package app.repositories;

import app.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Репозиторий для сущностей с ключами типа {@link Long}
 * @param <E> тип сущности, ограниченный {@link AbstractEntity}
 *
 * @author Александров Илья
 */
public interface LongKeyRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
