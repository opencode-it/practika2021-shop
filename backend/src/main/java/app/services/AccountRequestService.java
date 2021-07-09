package app.services;

import app.controllers.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.AccountRequestMapper;
import app.repositories.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountRequestService extends AbstractService<Account,
                                                    AccountDTO.Request.Create,
                                                    AccountRepository,
                                                    AccountRequestMapper> {

}
