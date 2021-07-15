package app.mappers.impl.unidirectional.request;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import app.mappers.RequestMapper;
import app.repositories.impl.AccountRepository;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class OrderDeleteOrderMapper implements RequestMapper<Order, OrdersDTO.Request.DeleteOrder> {
    @Autowired
    private AccountRepository accRepo;


    @Mapping(target = "account", ignore = true)
    @Mapping(target = "discount", ignore = true)
    @Mapping(target = "ordersProducts", ignore = true)
    @Mapping(target = "date", ignore = true)
    @Mapping(target = "orderStatus", ignore = true)

    @Override
     public abstract Order toEntity(OrdersDTO.Request.DeleteOrder dto);


}
