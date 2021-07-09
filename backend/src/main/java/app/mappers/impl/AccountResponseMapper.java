package app.mappers.impl;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsResponseMapper.class)
public interface AccountResponseMapper extends AbstractMapper<Account, AccountDTO.Response.GetFullInfo> {

}
