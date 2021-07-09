package app.controllers;


import app.services.AbstractService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для обработки CRUD запросов для прав аккаунтов
 * @author Krll
 * */
@RestController
@RequestMapping("rights")
public class RightsController extends RESTController{
    public RightsController(AbstractService Service) {
        super(Service);
    }
}
