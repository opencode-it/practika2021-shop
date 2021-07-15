package app.repositories.impl;

import app.entities.Rights;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RightsRepository extends LongKeyRepository<Rights> {

    Optional<Rights> findByName(String name);
}
