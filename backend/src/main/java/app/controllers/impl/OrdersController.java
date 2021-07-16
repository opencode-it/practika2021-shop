/*
 * Uliana
 */
package app.controllers.impl;

import app.dto.impl.OrdersDTO;
import app.services.ext.OrdersConfirmAndGetFullService;
import app.services.ext.OrdersDeleteAndGetFormedService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "Заказы", description = "Контроллер для обработки CRUD запросов для продуктов")
@RestController
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    OrdersConfirmAndGetFullService confirmAndGetFullService;

    @Autowired
    OrdersDeleteAndGetFormedService deleteAndGetFormedService;

    @Operation(
            summary = "Найти все",
            description = "Найти список всех совершенных пользователем заказов"
    )
    @GetMapping
    public List<OrdersDTO.Response.GetFormed> findAll() {
        return deleteAndGetFormedService.findAll();
    }



    @Operation(
            summary = "Просмотреть",
            description = "Просмотр одного конкретного заказа в истории"
    )
    @GetMapping("/{id}")
    public Optional<OrdersDTO.Response.GetFull> getBy(@PathVariable("id") Long id) {
        return confirmAndGetFullService.find(id);
    }



    @Operation(
            summary = "Оформить",
            description = "Подтвердить и сохранить оформленный заказ"
    )
    @PostMapping("/cart/formOrder")
    public OrdersDTO.Response.GetFull confirmOrder(
            @RequestBody OrdersDTO.Request.ConfirmOrder request) {
        return confirmAndGetFullService.create(request);
    }



    @Operation(
            summary = "Отменить",
            description = "Удалить/отменить выбранный уже оформленный заказ"
    )
    @DeleteMapping("/{id}")
    public void delete(@RequestBody OrdersDTO.Request.DeleteOrder request) {
            deleteAndGetFormedService.delete(request);
    }
}
