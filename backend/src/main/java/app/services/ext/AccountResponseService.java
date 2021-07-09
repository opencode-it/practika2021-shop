package app.services.ext;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.impl.AccountResponseMapper;
import app.repositories.impl.AccountRepository;
import app.services.AbstractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountResponseService extends AbstractService<Account,
                                                            AccountDTO.Response.GetFullInfo,
                                                            AccountRepository,
                                                            AccountResponseMapper> {

}
