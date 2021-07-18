/*
 * Uliana
 */
package app.controllers.impl;

import app.algorithms.recommendations.impl.CommonRecommendations;
import app.algorithms.recommendations.impl.TypeRecommendations;
import app.dto.impl.FilterProductDTO;
import app.dto.impl.ProductDTO;
import app.services.ext.ProductCreateAndGetBaseService;
import app.services.ext.ProductEditAndGetFullService;
import app.services.ext.ProductFilterAndGetBaseService;
import app.services.ext.ProductForAccountService;
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
    private ProductFilterAndGetBaseService filterBaseProducts;

    @Autowired
    private ProductEditAndGetFullService editFullProduct;

    @Autowired
    private ProductCreateAndGetBaseService createBaseProduct;


    private final ProductForAccountService recommendations
            = ProductForAccountService.with(new CommonRecommendations());
    private final ProductForAccountService typedRecommendations
            = ProductForAccountService.with(new TypeRecommendations());


    @Operation(
            summary = "Отобразить каталог",
            description = "Запрос на отображение товаров в каталоге"
    )
    @GetMapping
    public Optional<List<ProductDTO.Response.GetBase>> findAll(@RequestBody ProductDTO.Request.GetAll request) {
        return recommendations.recommendFor(request);
    }



    @Operation(
            summary = "Отобразить страницу с категорией товаров в каталоге",
            description = "Запрос на отображение товаров определенного типа в каталоге"
    )
    @GetMapping("/{type}")
    public Optional<List<ProductDTO.Response.GetBase>> findAllInType(@PathVariable String type,
                                                           @RequestBody ProductDTO.Request.GetTypeAll request) {
        request.setType(type);
        return typedRecommendations.recommendFor(request);

    }



    @Operation(
            summary = "Применить фильтр",
            description = "Запрос на отображение товаров по фильтру"
    )
    @GetMapping("/filtered")
    public Optional<List<ProductDTO.Response.GetBase>> findAllFiltered(
            @RequestBody FilterProductDTO.Request.FilterByCommonFeatures request) {
        return filterBaseProducts.findByFilter(request);
    }



    @Operation(
            summary = "Отобразить товар",
            description = "Запрос на открытие страницы конкретного товара"
    )
    @GetMapping("/{id}")
    public Optional<ProductDTO.Response.GetFull> getBy(@PathVariable("id") Long id,
                                                       @RequestBody ProductDTO.Request.GetForAccount request) {
        request.setProductId(id);
        return recommendations.find(id);
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
