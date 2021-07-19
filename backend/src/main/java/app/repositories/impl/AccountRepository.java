package app.repositories.impl;

import app.entities.Account;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountRepository extends LongKeyRepository<Account> {

    List<Account> findByToken(String token);
}
