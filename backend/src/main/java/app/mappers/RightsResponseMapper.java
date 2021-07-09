package app.mappers;

import app.controllers.dto.impl.RightsDTO;
import app.entities.Rights;
import org.mapstruct.Mapper;

@Mapper
public interface RightsResponseMapper extends AbstractMapper<Rights, RightsDTO.Response.Get> {

}
