package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.UnitsChangeMapper;
import app.mappers.impl.unidirectional.response.UnitsGetMapper;
import org.springframework.stereotype.Component;

@Component
public interface UnitsChangeAndGetMapper extends UnitsChangeMapper, UnitsGetMapper {

}
