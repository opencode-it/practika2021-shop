package app.mappers.impl.unidirectional.response;

import app.dto.impl.SlotDTO;
import app.entities.Slot;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.ProductToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomTypeMapper.class)
public interface SlotGetFullInfoMapper extends ResponseMapper<Slot, SlotDTO.Response.GetFullInfo> {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "product", target = "product", qualifiedBy = ProductToString.class)
    @Override
    SlotDTO.Response.GetFullInfo toDto(Slot entity);
}
