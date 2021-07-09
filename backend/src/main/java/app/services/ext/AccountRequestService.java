package app.services.ext;

import app.controllers.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.impl.AccountRequestMapper;
import app.repositories.impl.AccountRepository;
import app.services.AbstractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountRequestService extends AbstractService<Account,
                                                           AccountDTO.Request.Create,
                                                           AccountRepository,
                                                           AccountRequestMapper> {

}
