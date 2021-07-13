package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.FeatureDTO;
import app.services.ext.FeatureUpdateAndGetUnitsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * Контроллер для обработки CRUD запросов для характеристик товара
 * @author Krll
 * */
@RestController
@RequestMapping("feature")
public class FeatureController  extends RESTController<FeatureDTO.Request.Get,
                                                         FeatureDTO.Response.GetWithUnits,
                                                            FeatureUpdateAndGetUnitsService> {
    public FeatureController(FeatureUpdateAndGetUnitsService Service) {
        super(Service);
    }
}
