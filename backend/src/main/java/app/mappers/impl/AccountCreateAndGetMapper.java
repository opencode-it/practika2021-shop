package app.mappers.impl;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsChangeAndGetMapper.class)
public interface AccountCreateAndGetMapper extends AbstractMapper<Account,
                                                                  AccountDTO.Request.Create,
                                                                  AccountDTO.Response.GetFullInfo> {

}
