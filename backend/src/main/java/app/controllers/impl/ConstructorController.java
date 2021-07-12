/*
 * Uliana
 */
package app.controllers.impl;

import app.dto.impl.ImageDTO;
import app.dto.impl.ProductDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для работы с конструктором продукта
 */
@RestController
@RequestMapping("/products/costructor")
public class ConstructorController {

    /**
     * Открывает страницу конструктора для редактирования существующего
     * в каталоге товара
     */
    @GetMapping("/{id}")
    public ProductDTO.Response.GetFull editProduct(@PathVariable Integer id) {
        //TODO
    }

    /**
     * Для обработки изображения?
     */
    @PostMapping("/{id}")
    public ImageDTO.Response.GetRequestedImage updateProductImage(
            @RequestBody ImageDTO.Request.CustomizeImage request) {
        //TODO
    }
}
