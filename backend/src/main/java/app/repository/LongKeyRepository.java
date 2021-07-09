package app.repository;

import app.entities.AbstractEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LongKeyRepository<E extends AbstractEntity> extends JpaRepository<E, Long> {

}
