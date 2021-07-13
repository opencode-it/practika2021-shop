package app.mappers.impl.unidirectional.response;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface RightsGetMapper extends ResponseMapper<Rights, RightsDTO.Response.Get> {

}
