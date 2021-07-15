package app.mappers.impl.unidirectional.response;

import app.dto.impl.ProductDTO;
import app.entities.OrdersProducts;
import app.mappers.ResponseMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public abstract class OrdersProductGetBaseMapper implements ResponseMapper<OrdersProducts, ProductDTO.Response.GetOrderedBase> {
    @Mapping(source = "count", target = "amount")

    @Override
    public abstract ProductDTO.Response.GetOrderedBase toDto(OrdersProducts entity);

    @AfterMapping
    private void after(OrdersProducts source, @MappingTarget ProductDTO.Response.GetOrderedBase target) {
        target.setName(source.getProduct().getName());
        target.setType(source.getProduct().getType().getName());
        target.setBasePrice(source.getProduct().getPrice());
    }
}
