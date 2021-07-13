package app.mappers.impl.complete;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsChangeAndGetMapper.class)
public interface AccountCreateAndGetMapper extends CompleteMapper<Account,
                                                                  AccountDTO.Request.Create,
                                                                  AccountDTO.Response.GetFullInfo> {

}
