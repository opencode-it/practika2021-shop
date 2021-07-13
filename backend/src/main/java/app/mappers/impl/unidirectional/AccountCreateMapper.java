package app.mappers.impl.unidirectional;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.ToEntityMapper;
import org.mapstruct.Mapper;

@Mapper(uses = ChangeRightsMapper.class)
public interface AccountCreateMapper extends ToEntityMapper<Account, AccountDTO.Request.Create> {

}
