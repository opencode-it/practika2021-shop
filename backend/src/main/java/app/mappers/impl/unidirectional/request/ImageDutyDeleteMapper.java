package app.mappers.impl.unidirectional.request;

import app.dto.impl.ImageDutyDto;
import app.entities.ImageDuty;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface ImageDutyDeleteMapper extends RequestMapper<ImageDuty, ImageDutyDto.Request.Delete> {

    @Mapping(target = "name", ignore = true)
    @Override
    ImageDuty toEntity(ImageDutyDto.Request.Delete dto);
}