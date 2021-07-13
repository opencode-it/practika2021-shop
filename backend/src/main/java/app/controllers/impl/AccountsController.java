package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.AccountDTO;
import app.services.ext.AccountCreateAndGetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для обработки CRUD запросов для аккаунтов
 * @author Krll
 * */
@RestController
@RequestMapping("accounts")
public class AccountsController extends RESTController<AccountDTO.Request.Create,
                                                       AccountDTO.Response.GetFullInfo,
                                                       AccountCreateAndGetService> {
    public AccountsController(AccountCreateAndGetService Service) {
        super(Service);
    }


    @RequestMapping("/try")
    public String tryAdd(){
        AccountDTO.Request.Create save = new AccountDTO.Request.Create();
        save.setRights(Service.find(Long.valueOf(3) ).get().getRights());
        System.out.println(save.getRights().getName());

        Service.create(save);
        return "Hell";
    }
}
