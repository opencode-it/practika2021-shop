package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.UnitsDTO;
import app.services.ext.UnitsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Krll
 */
@Tag(name = "Единицы измерения", description = "Контроллер для обработки CRUD запросов для меры измерения хар-ки товара")
@RestController
@RequestMapping("units")
public class UnitsController extends RESTController<UnitsDTO.Request.AddUnits,
                                                    UnitsDTO.Response.Get,
                                                    UnitsService> {
    public UnitsController(UnitsService Service) {
        super(Service);
    }
}
