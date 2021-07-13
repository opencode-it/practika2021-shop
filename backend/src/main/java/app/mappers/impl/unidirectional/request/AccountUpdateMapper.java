package app.mappers.impl.unidirectional.request;

import app.dto.impl.AccountDTO;
import app.entities.Account;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper
public interface AccountUpdateMapper extends RequestMapper<Account, AccountDTO.Request.UpdateInfo> {

    @Mappings({
            @Mapping(target = "token", ignore = true),
            @Mapping(target = "rights", ignore = true)
    })
    @Override
    Account toEntity(AccountDTO.Request.UpdateInfo dto);
}
