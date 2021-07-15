package app.services.ext;

import app.dto.impl.OrdersDTO;
import app.entities.Order;

import app.mappers.impl.unidirectional.request.OrderProductsConfirmMapper;
import app.mappers.impl.unidirectional.response.OrderGetFullMapper;
import app.repositories.impl.OrdersRepository;
import app.services.CRUDService;

public class OrdersConfirmAndGetFullService extends CRUDService<Order, OrdersDTO.Request.ConfirmOrder,
        OrdersDTO.Response.GetFull,
        OrdersRepository,
        OrderProductsConfirmMapper, OrderGetFullMapper> {
}
