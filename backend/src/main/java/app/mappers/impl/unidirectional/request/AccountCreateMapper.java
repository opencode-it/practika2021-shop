package app.mappers.impl.unidirectional.request;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsChangeMapper.class)
public interface AccountCreateMapper extends RequestMapper<Account, AccountDTO.Request.Create> {

}
