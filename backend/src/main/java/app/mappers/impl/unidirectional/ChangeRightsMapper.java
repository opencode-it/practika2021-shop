package app.mappers.impl.unidirectional;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.ToEntityMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ChangeRightsMapper extends ToEntityMapper<Rights, RightsDTO.Request.ChangeRights> {

}
