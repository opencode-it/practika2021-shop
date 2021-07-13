package app.mappers.impl.unidirectional.request;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RightsCheckMapper extends RequestMapper<Rights, RightsDTO.Request.CheckRights> {

    @Mapping(target = "name", ignore = true)
    @Override
    Rights toEntity(RightsDTO.Request.CheckRights dto);
}
