package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.ImageDeleteMapper;
import app.mappers.impl.unidirectional.response.ImageGetResponseMapper;
import org.springframework.stereotype.Component;

@Component
public interface ImageDeleteAndGetMapper extends ImageDeleteMapper, ImageGetResponseMapper {

}
