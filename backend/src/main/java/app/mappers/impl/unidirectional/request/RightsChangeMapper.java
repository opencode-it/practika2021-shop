package app.mappers.impl.unidirectional.request;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;

@Mapper
public interface RightsChangeMapper extends RequestMapper<Rights, RightsDTO.Request.ChangeRights> {

}
