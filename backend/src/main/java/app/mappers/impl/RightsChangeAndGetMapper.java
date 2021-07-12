package app.mappers.impl;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface RightsChangeAndGetMapper extends AbstractMapper<Rights,
                                                                 RightsDTO.Request.ChangeRights,
                                                                 RightsDTO.Response.Get> {
    @Override
    @Mapping(target = "name", ignore = true)
    Rights toEntity(RightsDTO.Request.ChangeRights dto);
}
