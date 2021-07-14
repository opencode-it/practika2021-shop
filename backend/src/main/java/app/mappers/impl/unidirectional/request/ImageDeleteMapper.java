package app.mappers.impl.unidirectional.request;

import app.dto.impl.ImageDTO;
import app.entities.Image;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ImageDeleteMapper extends RequestMapper<Image, ImageDTO.Request.DeleteImage> {

    @Mapping(target = "duty", ignore = true)
    @Override
    Image toEntity(ImageDTO.Request.DeleteImage dto);
}
