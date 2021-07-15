package app.repositories.impl;

import app.entities.Visit;
import app.repositories.LongKeyRepository;

import java.util.List;
import java.util.stream.Collectors;

public abstract class VisitRepository implements LongKeyRepository<Visit> {
    public List<Visit> visitsOf(Long accountId) {
        return findAll().stream().filter(v ->
                v.getAccount().getId().equals(accountId))
                .collect(Collectors.toList());
    }
}
