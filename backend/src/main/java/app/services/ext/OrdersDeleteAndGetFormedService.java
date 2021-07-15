package app.services.ext;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import app.mappers.impl.unidirectional.request.OrderDeleteOrderMapper;
import app.mappers.impl.unidirectional.response.OrderGetFormedMapper;
import app.repositories.impl.OrdersRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrdersDeleteAndGetFormedService extends CRUDService<Order, OrdersDTO.Request.DeleteOrder,
        OrdersDTO.Response.GetFormed,
        OrdersRepository,
        OrderDeleteOrderMapper, OrderGetFormedMapper> {

}
