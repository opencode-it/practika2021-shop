package app.repositories.impl;

import app.entities.Units;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UnitsRepository extends LongKeyRepository<Units> {

}
