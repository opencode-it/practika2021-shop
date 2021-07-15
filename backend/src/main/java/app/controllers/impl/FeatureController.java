package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.FeatureDTO;
import app.services.ext.FeatureUpdateAndGetUnitsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * @author Krll
 */
@Tag(name = "Характеристики", description = "Контроллер для обработки CRUD запросов для характеристик товара")
@RestController
@RequestMapping("feature")
public class FeatureController  extends RESTController<FeatureDTO.Request.UpdateUnits,
                                                         FeatureDTO.Response.GetWithUnits,
                                                            FeatureUpdateAndGetUnitsService> {
    public FeatureController(FeatureUpdateAndGetUnitsService Service) {
        super(Service);
    }

    @Operation(
            summary = "Информация о характеристике",
            description = "Получает информацию о характеристике"
    )
    @Override
    public Optional<FeatureDTO.Response.GetWithUnits> getBy(Long id) {
        return super.getBy(id);
    }

    @Operation(
            summary = "Создать",
            description = "Создать новую характеристику и сохранить в БД"
    )
    @Override
    public FeatureDTO.Request.UpdateUnits save(FeatureDTO.Request.UpdateUnits inputAcc) {
        return super.save(inputAcc);
    }

    @Operation(
            summary = "Редактировать",
            description = "Обновить информацию о характеристике в БД"
    )
    @Override
    public FeatureDTO.Request.UpdateUnits edit(Long id, FeatureDTO.Request.UpdateUnits edited) {
        return super.edit(id, edited);
    }

    @Operation(
            summary = "Удалить",
            description = "Удалить характеристику по id"
    )
    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
