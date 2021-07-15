package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.UnitsDTO;
import app.services.ext.UnitsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Контроллер для обработки CRUD запросов для меры измерения хар-ки товара
 * @author Krll
 * */
@RestController
@RequestMapping("units")
public class UnitsController extends RESTController<UnitsDTO.Request.AddUnits,
                                                    UnitsDTO.Response.Get,
                                                    UnitsService> {
    public UnitsController(UnitsService Service) {
        super(Service);
    }
}
