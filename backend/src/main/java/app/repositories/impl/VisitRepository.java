package app.repositories.impl;

import app.entities.Visit;
import app.repositories.LongKeyRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public interface VisitRepository extends LongKeyRepository<Visit> {

    public Optional<List<Visit>> findByAccountId(Long accountId);
}
