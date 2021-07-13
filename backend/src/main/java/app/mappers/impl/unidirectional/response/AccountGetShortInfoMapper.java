package app.mappers.impl.unidirectional.response;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface AccountGetShortInfoMapper extends ResponseMapper<Account, AccountDTO.Response.GetShortInfo> {

}
