package app.mappers.impl.unidirectional.request;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import app.mappers.RequestMapper;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface OrderChangeAmountMapper extends RequestMapper<Order, OrdersDTO.Request.ChangeProductAmount>
{

    @Mapping(target = "account", ignore = true)
    @Mapping(target = "products", ignore = true)
    @Mapping(target = "discount", ignore = true)
    @Mapping(target = "count", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)
    @Override
    Order toEntity(OrdersDTO.Request.ChangeProductAmount dto);

    @AfterMapping
    static void changeProductAmount(OrdersDTO.Request.ChangeProductAmount source, @MappingTarget Order target) {
        //ToDo: логика по запросу ChangeProductAmount, ClearCart, ConfirmOrder, DeleteOrder
    }
}
