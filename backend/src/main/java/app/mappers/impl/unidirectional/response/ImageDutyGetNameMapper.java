package app.mappers.impl.unidirectional.response;

import app.dto.impl.ImageDutyDto;
import app.entities.ImageDuty;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper
public interface ImageDutyGetNameMapper extends ResponseMapper<ImageDuty, ImageDutyDto.Response.getName> {

}
