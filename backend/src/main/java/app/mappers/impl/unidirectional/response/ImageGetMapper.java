package app.mappers.impl.unidirectional.response;

import app.dto.impl.ImageDTO;
import app.entities.Image;
import app.mappers.CustomTypeMapper;
import app.mappers.ResponseMapper;
import app.mappers.qualifiers.ImageDutyToString;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomTypeMapper.class)
public interface ImageGetMapper extends ResponseMapper<Image, ImageDTO.Response.GetImage> {

    @Mapping(target = "id", ignore = true)
    @Mapping(source = "duty", target = "ImageDuty", qualifiedBy = ImageDutyToString.class)
    @Override
    ImageDTO.Response.GetImage toDto(Image entity);
}
