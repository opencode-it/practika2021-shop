package app.dto.interfaces.product;

import app.dto.impl.ImageDTO;

import java.util.Set;

public interface ImagesSet {
    Set<ImageDTO.Response.GetImage> getImagesSet();
}
