package app.mappers.impl.unidirectional.response;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface UnitsGetMapper extends ResponseMapper<Units, UnitsDTO.Response.Get> {

}
