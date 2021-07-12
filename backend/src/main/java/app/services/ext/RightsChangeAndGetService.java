package app.services.ext;

import app.dto.impl.RightsDTO;
import app.entities.Rights;
import app.mappers.impl.RightsChangeAndGetMapper;
import app.repositories.RightsRepository;
import app.services.AbstractService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RightsChangeAndGetService extends AbstractService<Rights,
                                                               RightsDTO.Request.ChangeRights,
                                                               RightsDTO.Response.Get,
                                                               RightsRepository,
                                                               RightsChangeAndGetMapper> {

}
