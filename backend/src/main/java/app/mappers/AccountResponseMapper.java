package app.mappers;

import app.controllers.dto.impl.AccountDTO;
import app.entities.Account;
import org.mapstruct.Mapper;

@Mapper(uses = RightsResponseMapper.class)
public interface AccountResponseMapper extends AbstractMapper<Account, AccountDTO.Response.GetFullInfo> {

}
