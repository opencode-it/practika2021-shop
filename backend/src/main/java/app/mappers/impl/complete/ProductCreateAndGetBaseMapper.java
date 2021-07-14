package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.ProductCreateMapper;
import app.mappers.impl.unidirectional.response.ProductGetBaseMapper;
import org.springframework.stereotype.Component;

@Component
public interface ProductCreateAndGetBaseMapper extends ProductCreateMapper, ProductGetBaseMapper {

}
