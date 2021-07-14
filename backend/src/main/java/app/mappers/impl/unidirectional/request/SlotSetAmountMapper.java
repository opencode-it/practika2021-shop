package app.mappers.impl.unidirectional.request;

import app.dto.impl.SlotDTO;
import app.entities.Slot;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface SlotSetAmountMapper extends RequestMapper<Slot, SlotDTO.Request.SetAmount> {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "product", target = "product", ignore = true)
    @Override
    Slot toEntity(SlotDTO.Request.SetAmount dto);
}
