package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.response.ImageGetResponseMapper;
import app.mappers.impl.unidirectional.request.ImageLoadCustomMapper;
import org.springframework.stereotype.Component;

@Component
public interface ImageLoadCustomAndGetMapper extends ImageLoadCustomMapper, ImageGetResponseMapper {

}
