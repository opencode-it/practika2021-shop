package app.mappers.impl;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface RightsChangeAndGetMapper extends AbstractMapper<Rights,
                                                                 RightsDTO.Request.ChangeRights,
                                                                 RightsDTO.Response.Get> {

}