package app.mappers.impl.unidirectional.request;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import app.mappers.RequestMapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface OrdersGetMapper extends RequestMapper<Order, OrdersDTO.Request.Get> {

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "discount", ignore = true)
    @Mapping(target = "count", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Override
    Order toEntity(OrdersDTO.Request.Get dto);
}
