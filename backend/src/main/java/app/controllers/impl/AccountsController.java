package app.controllers.impl;

import app.controllers.RESTController;
import app.dto.impl.AccountDTO;
import app.services.ext.AccountCreateAndGetService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


/**
 * Контроллер для обработки CRUD запросов для аккаунтов
 * @author Krll
 * */
@Tag(name = "Аккаунты", description = "Контроллер для аккаунтов")
@RestController
@RequestMapping("accounts")
public class AccountsController extends RESTController<AccountDTO.Request.Create,
                                                       AccountDTO.Response.GetFullInfo,
                                                       AccountCreateAndGetService> {

    public AccountsController(AccountCreateAndGetService Service) {
        super(Service);
    }

    @Operation(
            summary = "Информация об аккаунте",
            description = "Получить информацию об аккаунте по id"
    )
    @Override
    public Optional<AccountDTO.Response.GetFullInfo> getBy(Long id) {
        return super.getBy(id);
    }

    @Operation(
            summary = "Создать аккаунт",
            description = "Создать и сохранить аккаунт в БД"
    )
    @Override
    public AccountDTO.Request.Create save(AccountDTO.Request.Create inputAcc) {
        return super.save(inputAcc);
    }

    @Operation(
            summary = "Редактировать",
            description = "Обновить информацию об аккаунте в БД"
    )
    @Override
    public AccountDTO.Request.Create edit(Long id, AccountDTO.Request.Create edited) {
        return super.edit(id, edited);
    }

    @Operation(
            summary = "Удалить",
            description = "Удалить аккаунт по id"
    )
    @Override
    public void delete(Long id) {
        super.delete(id);
    }
}
