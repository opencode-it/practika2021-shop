package app.mappers.impl;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsRequestMapper.class)
public interface AccountRequestMapper extends AbstractMapper<Account, AccountDTO.Request.Create> {

}
