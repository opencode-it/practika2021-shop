package app.mappers.impl.unidirectional.request;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.RequestMapper;
import org.mapstruct.Mapping;

public interface UnitsChangeMapper extends RequestMapper<Units, UnitsDTO.Request.ChangeUnits> {

    @Mapping(target = "name", ignore = true)
    @Override
    Units toEntity(UnitsDTO.Request.ChangeUnits dto);
}
