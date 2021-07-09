package app.services;

import app.controllers.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.AccountResponseMapper;
import app.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountResponseService extends AbstractService<Account,
                                                            AccountDTO.Response.GetFullInfo,
                                                            AccountRepository,
                                                            AccountResponseMapper> {

}
