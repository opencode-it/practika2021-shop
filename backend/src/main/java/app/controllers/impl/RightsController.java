package app.controllers.impl;


import app.controllers.RESTController;
import app.dto.impl.RightsDTO;
import app.services.ext.RightsChangeAndGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@Tag(name = "Права", description = "Контроллер для обработки CRUD запросов для прав аккаунтов")
@RestController
@RequestMapping("rights")
public class RightsController extends RESTController<RightsDTO.Request.AddRights, RightsDTO.Response.Get, RightsChangeAndGetService> {
    public RightsController(RightsChangeAndGetService Service) {
        super(Service);
    }

    @Operation(
            summary = "Информация о правах",
            description = "Отобразить информацию о правах"
    )
    @Override
    public Optional<RightsDTO.Response.Get> getBy(Long id) {
        return super.getBy(id);
    }

    @Operation(
            summary = "Создать",
            description = "Создать и сохранить права аккаунта в БД"
    )
    @Override
    public RightsDTO.Request.AddRights save(RightsDTO.Request.AddRights inputAcc) {
        return super.save(inputAcc);
    }

    @Operation(
            summary = "Редактировать",
            description = "Редактировать информацию о правах"
    )
    @Override
    public RightsDTO.Request.AddRights edit(Long id, RightsDTO.Request.AddRights edited) {
        return super.edit(id, edited);
    }

    @Operation(
            summary = "Удалить",
            description = "Удалить информацию о правах"
    )
    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
