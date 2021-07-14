package app.services.ext;

import app.dto.impl.ImageDTO;
import app.entities.Image;
import app.mappers.impl.unidirectional.request.ImageDeleteMapper;
import app.mappers.impl.unidirectional.response.ImageGetResponseMapper;
import app.repositories.impl.ImageRepository;
import app.services.CRUDService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageDeleteAndGetService extends CRUDService<Image,
                                                          ImageDTO.Request.DeleteImage,
                                                          ImageDTO.Response.GetImage,
                                                          ImageRepository,
        ImageDeleteMapper, ImageGetResponseMapper> {

}
