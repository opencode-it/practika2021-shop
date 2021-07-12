/*
* Uliana
*/
package app.controllers.impl;

import app.dto.impl.ProductDTO;
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
 * */
@RestController
@RequestMapping("/products")
public class ProductsController {
    /*@Autowired
    protected S Service;*/

    /**
     * Запрос на отображение товаров в каталоге
     */
    @GetMapping
    public List<ProductDTO.Response.GetBase> findAll() {
        //TODO
    }

    /**
     * Запрос на открытие страницы конкретного товара
     */
    @GetMapping("/{id}")
    public ProductDTO.Response.GetFull getBy(@PathVariable("id") Long id) {
        //TODO
    }

    /**
     * Запрос на добавление нового продукта
     */
    @PostMapping("/newProduct")
    public void save(@RequestBody ProductDTO.Request.CreateProduct newProduct ) {
        //TODO
    }

    /**
     * Запрос на изменение существующего продукта
     */
    @PutMapping("/{id}/edit")
    public ProductDTO.Response.GetFull edit(@PathVariable("id") String id,
                                            @RequestBody ProductDTO.Request.EditProduct request) {
        //TODO
    }

    /**
     * Запрос на удаление существующего продукта
     */
    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Integer id) {
        //TODO
    }
}
