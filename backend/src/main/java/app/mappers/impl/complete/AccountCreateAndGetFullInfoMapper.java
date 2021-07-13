package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.AccountCreateMapper;
import app.mappers.impl.unidirectional.response.AccountGetFullInfoMapper;
import org.mapstruct.Mapper;

@Mapper(uses = RightsChangeAndGetMapper.class)
public interface AccountCreateAndGetFullInfoMapper extends AccountCreateMapper, AccountGetFullInfoMapper {

}
