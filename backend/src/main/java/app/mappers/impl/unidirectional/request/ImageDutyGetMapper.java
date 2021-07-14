package app.mappers.impl.unidirectional.request;

import app.dto.impl.ImageDutyDto;
import app.entities.ImageDuty;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ImageDutyGetMapper extends RequestMapper<ImageDuty, ImageDutyDto.Request.Get> {

    @Mapping(target = "name", ignore = true)
    @Override
    ImageDuty toEntity(ImageDutyDto.Request.Get dto);
}
