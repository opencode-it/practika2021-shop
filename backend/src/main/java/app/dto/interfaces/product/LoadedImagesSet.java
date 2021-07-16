package app.dto.interfaces.product;

import app.dto.impl.ImageDTO;

import java.util.Set;

public interface LoadedImagesSet {
    Set<ImageDTO.Request.Get> getImages();
}
