/*
 * Uliana
 */
package app.controllers.impl;

import app.dto.impl.FilterProductDTO;
import app.dto.impl.ProductDTO;
import app.services.ext.ProductCreateAndGetBaseService;
import app.services.ext.ProductEditAndGetFullService;
import app.services.ext.ProductFilterAndGetFullService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@Tag(name = "Продукты", description = "Контроллер для обработки CRUD запросов для продуктов")
@RestController
@RequestMapping("/products")
public class ProductsController {
    @Autowired
    private ProductFilterAndGetFullService filterBaseProducts;

    @Autowired
    private ProductEditAndGetFullService editFullProduct;

    @Autowired
    private ProductCreateAndGetBaseService createBaseProduct;

    @Operation(
            summary = "Отобразить каталог",
            description = "Запрос на отображение товаров в каталоге"
    )
    @GetMapping
    public List<ProductDTO.Response.GetFull> findAll() {
        return filterBaseProducts.findAll();
    }

    @Operation(
            summary = "Применить фильтр",
            description = "Запрос на отображение товаров по фильтру"
    )
    @GetMapping("/filtered")
    public Optional<List<ProductDTO.Response.GetFull>> findAllFiltered(
            @RequestBody FilterProductDTO.Request.FilterByCommonFeatures request) {
        return filterBaseProducts.findByFilter(request);
    }

    @Operation(
            summary = "Отобразить товар",
            description = "Запрос на открытие страницы конкретного товара"
    )
    @GetMapping("/{id}")
    public Optional<ProductDTO.Response.GetFull> getBy(@PathVariable("id") Long id) {
        return editFullProduct.find(id);
    }

    @Operation(
            summary = "Добавить товар",
            description = "Запрос на добавление нового товара"
    )
    @PostMapping("/newProduct")
    public void save(@RequestBody ProductDTO.Request.CreateProduct newProduct) {
        createBaseProduct.create(newProduct);
    }

    @Operation(
            summary = "Изменить",
            description = "Запрос на изменение существующего продукта"
    )
    @PutMapping("/{id}/edit")
    public Optional<ProductDTO.Response.GetFull> edit(@PathVariable("id") Long id,
                                                      @RequestBody ProductDTO.Request.EditProduct request) {
        editFullProduct.create(request);
        return editFullProduct.find(id);
    }

    @Operation(
            summary = "Удалить",
            description = "Запрос на удаление существующего продукта"
    )
    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable("id") Long id) {
        editFullProduct.delete(id);
    }
}
