package app.controllers;

import app.services.CRUDService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для обработки CRUD запросов для аккаунтов
 * @author Krll
 * */
@RestController
@RequestMapping("accounts")
public class AccountsController extends RESTController{
    public AccountsController(CRUDService Service) {
        super(Service);
    }
}
