package app.mappers.impl.unidirectional.response;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsGetMapper.class)
public interface AccountGetFullInfoMapper extends ResponseMapper<Account, AccountDTO.Response.GetFullInfo> {

}
