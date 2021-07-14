package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.ImageGetRequestMapper;
import app.mappers.impl.unidirectional.response.ImageGetResponseMapper;
import org.springframework.stereotype.Component;

@Component
public interface ImageGetMapper extends ImageGetRequestMapper, ImageGetResponseMapper {

}
