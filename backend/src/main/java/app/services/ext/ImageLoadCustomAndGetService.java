package app.services.ext;

import app.dto.impl.ImageDTO;
import app.entities.Image;
import app.mappers.impl.unidirectional.request.ImageLoadCustomMapper;
import app.mappers.impl.unidirectional.response.ImageGetResponseMapper;
import app.repositories.impl.ImageRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageLoadCustomAndGetService extends CRUDService<Image,
                                                              ImageDTO.Request.LoadCustom,
                                                              ImageDTO.Response.GetImage,
                                                              ImageRepository,
                                                              ImageLoadCustomMapper,
                                                              ImageGetResponseMapper> {

}
