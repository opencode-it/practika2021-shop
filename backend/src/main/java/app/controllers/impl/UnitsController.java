package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.UnitsDTO;
import app.services.ext.UnitsService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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

    @Operation(
            summary = "Информация о единицах измерения",
            description = "Отобразить информацию о единицах измерения"
    )
    @Override
    public Optional<UnitsDTO.Response.Get> getBy(Long id) {
        return super.getBy(id);
    }



    @Operation(
            summary = "Создать",
            description = "Создать и сохранить единицы измерения в БД"
    )
    @Override
    public UnitsDTO.Request.AddUnits save(UnitsDTO.Request.AddUnits inputAcc) {
        return super.save(inputAcc);
    }



    @Operation(
            summary = "Редактировать",
            description = "Редактировать информацию о единицах измерения"
    )
    @Override
    public UnitsDTO.Request.AddUnits edit(Long id, UnitsDTO.Request.AddUnits edited) {
        return super.edit(id, edited);
    }



    @Operation(
            summary = "Удалить",
            description = "Удалить информацию о единицах измерения"
    )
    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
