package app.repositories.impl;

import app.entities.Rights;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RightsRepository extends LongKeyRepository<Rights> {

}
