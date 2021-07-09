package app.repositories.impl;

import app.entities.Account;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends LongKeyRepository<Account> {

}
