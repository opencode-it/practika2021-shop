package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.AccountCreateMapper;
import app.mappers.impl.unidirectional.response.AccountGetFullInfoMapper;

public interface AccountCreateAndGetMapper extends AccountCreateMapper, AccountGetFullInfoMapper {

}