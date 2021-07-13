package app.mappers.impl.complete;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper
public interface RightsChangeAndGetMapper extends CompleteMapper<Rights,
                                                                 RightsDTO.Request.ChangeRights,
                                                                 RightsDTO.Response.Get> {

}
