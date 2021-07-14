package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.RightsChangeMapper;
import app.mappers.impl.unidirectional.response.RightsGetMapper;
import org.springframework.stereotype.Component;

@Component
public interface RightsChangeAndGetMapper extends RightsChangeMapper, RightsGetMapper {

}
