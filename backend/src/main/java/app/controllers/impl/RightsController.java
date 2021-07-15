package app.controllers.impl;


import app.controllers.RESTController;
import app.dto.impl.RightsDTO;
import app.services.ext.RightsChangeAndGetService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Права", description = "Контроллер для обработки CRUD запросов для прав аккаунтов")
@RestController
@RequestMapping("rights")
public class RightsController extends RESTController<RightsDTO.Request.AddRights, RightsDTO.Response.Get, RightsChangeAndGetService> {
    public RightsController(RightsChangeAndGetService Service) {
        super(Service);
    }
}
