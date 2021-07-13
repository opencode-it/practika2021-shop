package app.mappers.impl.unidirectional.request;

import app.dto.impl.SlotDTO;
import app.entities.Slot;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SlotSetAmountOnIdMapper extends RequestMapper<Slot, SlotDTO.Request.SetAmountOnId> {

    @Mapping(target = "product", ignore = true)
    @Override
    Slot toEntity(SlotDTO.Request.SetAmountOnId dto);
}
