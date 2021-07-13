/*
 * Uliana
 */
package app.controllers.impl;

import app.dto.impl.ImageDTO;
import app.dto.impl.ProductDTO;
import app.services.ext.ProductEditAndGetFullService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Контроллер для работы с конструктором продукта
 */
@RestController
@RequestMapping("/products/costructor")
public class ConstructorController {
    @Autowired
    private ProductEditAndGetFullService editFullProduct;

    /**
     * Открывает страницу конструктора для редактирования существующего
     * в каталоге товара
     */
    @GetMapping("/{id}")
    public Optional<ProductDTO.Response.GetFull> editProduct(@PathVariable Long id) {
        return editFullProduct.find(id);
    }

    /**
     * Для обработки изображения?
     */
    @PostMapping("/{id}")
    public ImageDTO.Response.GetRequestedImage updateProductImage(
            @RequestBody ImageDTO.Request.CustomizeImage request) {
        //TODO
        return null;
    }
}
