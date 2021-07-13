package app.mappers.impl.complete;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.CompleteMapper;
import org.mapstruct.Mapper;

@Mapper
public interface UnitsMapper extends CompleteMapper<Units,
                                                    UnitsDTO.Request.ChangeUnits,
                                                    UnitsDTO.Response.Get> {

}
