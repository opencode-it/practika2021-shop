package app.services.ext;

import app.dto.impl.UnitsDTO;
import app.entities.Units;
import app.mappers.impl.unidirectional.request.UnitsChangeMapper;
import app.mappers.impl.unidirectional.response.UnitsGetMapper;
import app.repositories.impl.UnitsRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UnitsService extends CRUDService<Units,
                                              UnitsDTO.Request.AddUnits,
                                              UnitsDTO.Response.Get,
                                              UnitsRepository,
                                              UnitsChangeMapper,
                                              UnitsGetMapper> {

}
