package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.UnitsChangeMapper;
import app.mappers.impl.unidirectional.response.UnitsGetMapper;
import org.mapstruct.Mapper;

@Mapper
public interface UnitsMapper extends UnitsChangeMapper, UnitsGetMapper {

}
