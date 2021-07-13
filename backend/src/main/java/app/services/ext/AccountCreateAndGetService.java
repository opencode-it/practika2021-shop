package app.services.ext;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.impl.complete.AccountCreateAndGetMapper;
import app.repositories.impl.AccountRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountCreateAndGetService extends CRUDService<Account,
                                                            AccountDTO.Request.Create,
                                                            AccountDTO.Response.GetFullInfo,
                                                            AccountRepository,
        AccountCreateAndGetMapper> {

}
