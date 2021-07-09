package app.repositories;

import app.entities.Account;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends LongKeyRepository<Account> {

}
