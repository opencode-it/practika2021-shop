package app.mappers;

import app.controllers.dto.impl.AccountDTO;
import app.entities.Account;
import org.mapstruct.Mapper;

@Mapper(uses = RightsRequestMapper.class)
public interface AccountRequestMapper extends AbstractMapper<Account, AccountDTO.Request.Create> {

}
