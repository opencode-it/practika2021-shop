package app.services.ext;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.impl.complete.RightsChangeAndGetMapper;
import app.mappers.impl.unidirectional.request.RightsChangeMapper;
import app.mappers.impl.unidirectional.response.RightsGetMapper;
import app.repositories.impl.RightsRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RightsChangeAndGetService extends CRUDService<Rights,
                                                           RightsDTO.Request.ChangeRights,
                                                           RightsDTO.Response.Get,
                                                           RightsRepository,
        RightsChangeMapper, RightsGetMapper> {

}
