/*
 * Uliana
 */
package app.controllers.impl;

import app.dto.impl.OrdersDTO;
import app.entities.Order;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Контроллер для обработки CRUD запросов для продуктов
 */
@RestController
@RequestMapping("/orders")
public class OrdersController {
     /*@Autowired
    protected S Service;*/

    /**
     * Список всех совершенных пользователем заказов
     */
    @GetMapping
    public List<OrdersDTO.Response.GetFormed> findAll() {
        //TODO
    }

    /**
     * Просмотр одного конкретного заказа в истории
     */
    @GetMapping("/{id}")
    public OrdersDTO.Response.GetFull getBy(@PathVariable("id") Long id) {
        //TODO
    }

    /**
     * Просмотр корзины.
     */
    @GetMapping("/cart")
    public OrdersDTO.Response.GetFormed showCart() {
        //TODO
    }

    /**
     * Подтвердить и сохранить оформленный заказ
     */
    @PostMapping("/cart/formOrder")
    public void confirmOrder(@RequestBody OrdersDTO.Request.ConfirmOrder request) {
        //TODO
    }


    /**
     * Удалить/отменить выбранный уже оформленный заказ
     */
    @DeleteMapping("/{id}")
    public void delete(@RequestBody OrdersDTO.Request.DeleteOrder request) {
        //TODO
    }

}
