package app.controllers;

import app.dto.impl.AccountDTO;
import app.services.CRUDService;
import app.services.ext.AccountCreateAndGetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для обработки CRUD запросов для аккаунтов
 * @author Krll
 * */
@RestController
@RequestMapping("accounts")
public class AccountsController extends RESTController<AccountDTO.Request.Create, AccountDTO.Response.GetFullInfo, AccountCreateAndGetService>{
    public AccountsController(AccountCreateAndGetService Service) {
        super(Service);
    }
}
