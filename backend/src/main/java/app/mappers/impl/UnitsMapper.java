package app.mappers.impl;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.AbstractMapper;
import org.mapstruct.Mapper;

@Mapper
public interface UnitsMapper extends AbstractMapper<Units,
                                                    UnitsDTO.Request.ChangeUnits,
                                                    UnitsDTO.Response.Get> {

}
