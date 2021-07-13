package app.mappers.impl.unidirectional.response;

import app.dto.impl.SlotDTO;
import app.entities.Slot;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface SlotGetAmountMapper extends ResponseMapper<Slot, SlotDTO.Response.GetAmountOnId> {

}
