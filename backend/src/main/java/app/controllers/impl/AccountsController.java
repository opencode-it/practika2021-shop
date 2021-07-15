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
@RestController
@RequestMapping("accounts")
@Tag(name = "Аккаунты", description = "Контроллер для аккаунтов")
public class AccountsController extends RESTController<AccountDTO.Request.Create,
                                                       AccountDTO.Response.GetFullInfo,
                                                       AccountCreateAndGetService> {

    public AccountsController(AccountCreateAndGetService Service) {
        super(Service);
    }

    @Operation(
            summary = "Реализация GET-запроса",
            description = "Позволяет получить информацию об аккаунте"
    )
    @Override
    public Optional<AccountDTO.Response.GetFullInfo> getBy(Long id) {
        return super.getBy(id);
    }
}
