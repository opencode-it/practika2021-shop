package app.controllers;


import app.dto.impl.AccountDTO;
import app.dto.impl.RightsDTO;
import app.services.CRUDService;
import app.services.ext.AccountCreateAndGetService;
import app.services.ext.RightsChangeAndGetService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Контроллер для обработки CRUD запросов для прав аккаунтов
 * @author Krll
 * */
@RestController
@RequestMapping("rights")
public class RightsController extends RESTController<RightsDTO.Request.ChangeRights, RightsDTO.Response.Get, RightsChangeAndGetService>{
    public RightsController(RightsChangeAndGetService Service) {
        super(Service);
    }
}