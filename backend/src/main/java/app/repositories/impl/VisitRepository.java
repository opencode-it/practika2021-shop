package app.repositories.impl;

import app.entities.Visit;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends LongKeyRepository<Visit> {

    Optional<List<Visit>> findByAccountId(Long accountId);
}
