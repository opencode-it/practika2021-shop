package app.mappers.impl.unidirectional.request;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UnitsChangeMapper extends RequestMapper<Units, UnitsDTO.Request.ChangeUnits> {

    @Mapping(target = "name", ignore = true)
    @Override
    Units toEntity(UnitsDTO.Request.ChangeUnits dto);
}
