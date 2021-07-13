package app.mappers.impl.unidirectional.response;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import app.mappers.ResponseMapper;
import org.mapstruct.Mapper;

@Mapper(uses = ProductGetBaseMapper.class)
public interface OrderGetFormedMapper extends ResponseMapper<Order, OrdersDTO.Response.GetFormed> {

    @Override
    OrdersDTO.Response.GetFormed toDto(Order entity);


}
