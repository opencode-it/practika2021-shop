package app.services.ext;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.impl.unidirectional.request.AccountCreateMapper;
import app.mappers.impl.unidirectional.response.AccountGetFullInfoMapper;
import app.mappers.impl.unidirectional.response.RightsGetMapper;
import app.repositories.impl.AccountRepository;
import app.repositories.impl.RightsRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountCreateAndGetService extends CRUDService<Account,
                                                            AccountDTO.Request.Create,
                                                            AccountDTO.Response.GetFullInfo,
                                                            AccountRepository,
                                                            AccountCreateMapper,
                                                            AccountGetFullInfoMapper> {

    @Autowired
    RightsRepository rightsRepository;

    @Autowired
    RightsGetMapper rightsMapper;

    @Override
    public AccountDTO.Response.GetFullInfo create(AccountDTO.Request.Create dto) {
        rightsRepository.findByName(dto.getRights().getName())
                .ifPresent(r -> dto.setRights(rightsMapper.toDto(r)));
        Account createdAccount = repository.save(requestMapper.toEntity(dto));
        return responseMapper.toDto(createdAccount);
    }

    Optional<List<AccountDTO.Response.GetFullInfo>> findByToken(AccountDTO.Request.Get dto) {
         List<Account> accountsWithToken = repository.findByToken(dto.getToken());
         return Optional.of(responseMapper.toDtoList(accountsWithToken));
    }
}
