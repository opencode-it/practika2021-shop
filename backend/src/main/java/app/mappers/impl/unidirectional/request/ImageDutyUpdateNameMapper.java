package app.mappers.impl.unidirectional.request;

import app.dto.impl.ImageDutyDto;
import app.entities.ImageDuty;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ImageDutyUpdateNameMapper extends RequestMapper<ImageDuty, ImageDutyDto.Request.UpdateName> {

}
