package app.mappers.impl.unidirectional.request;

import app.dto.impl.ImageDTO;
import app.entities.Image;
import app.mappers.CustomTypeMapper;
import app.mappers.RequestMapper;
import app.mappers.qualifiers.StringToImageDuty;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = CustomTypeMapper.class)
public interface ImageGetMapper extends RequestMapper<Image, ImageDTO.Request.Get> {

    @Mapping(target = "path", ignore = true)
    @Mapping(source = "imageDuty", target = "duty", qualifiedBy = StringToImageDuty.class)
    @Override
    Image toEntity(ImageDTO.Request.Get dto);

}
