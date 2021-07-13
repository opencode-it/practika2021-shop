package app.mappers.impl.complete;

import app.mappers.impl.unidirectional.request.ProductEditMapper;
import app.mappers.impl.unidirectional.response.ProductGetFullMapper;
import org.springframework.stereotype.Component;

@Component
public interface ProductEditAndGetFullMapper extends ProductEditMapper, ProductGetFullMapper {

}
