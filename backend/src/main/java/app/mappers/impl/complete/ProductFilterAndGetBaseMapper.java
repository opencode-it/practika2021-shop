package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.ProductFilterMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface ProductFilterAndGetBaseMapper extends ProductFilterMapper, ProductGetBaseMapper {

}
