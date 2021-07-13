package app.mappers.impl.unidirectional.request;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface AccountDeleteMapper extends RequestMapper<Account, AccountDTO.Request.Delete> {

    @Mapping(target = "token", ignore = true)
    @Mapping(target = "rights", ignore = true)
    @Mapping(target = "email", ignore = true)
    @Mapping(target = "address", ignore = true)
    @Mapping(target = "fullName", ignore = true)
    @Override
    Account toEntity(AccountDTO.Request.Delete dto);
}
