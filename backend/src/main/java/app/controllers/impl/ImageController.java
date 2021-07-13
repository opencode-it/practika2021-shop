package app.controllers.impl;

import app.dto.impl.ImageDTO;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер, работающий с изображениями,
 * поступающими на сервер
 */
@RestController
@RequestMapping("/assets/images")
public class ImageController {
    //Изображения изначально поступают на клиент вместе
    //с товарами или заказами, поэтому путь к ним и
    //их предназначение всегда известны

    /**
     * Запросить изображение еще раз для конкретного продукта
     */
    @GetMapping
    public ImageDTO.Response.GetRequestedImage getBy(
            @RequestBody ImageDTO.Request.Get request) {
        //TODO
    }

    /**
     * Загрузить новое изображение на сервер
     */
    @PostMapping("/load")
    public ImageDTO.Response.GetRequestedImage loadCustom(
            @RequestBody ImageDTO.Request.LoadCustom request) {
        //TODO
    }


    /**
     * Удалить изображение
     */
    @DeleteMapping("/delete")
    public void delete(@RequestBody ImageDTO.Request.DeleteImage request) {
        //TODO
    }
}
