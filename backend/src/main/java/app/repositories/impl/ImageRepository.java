package app.repositories.impl;

import app.entities.Image;
import app.repositories.LongKeyRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImageRepository extends LongKeyRepository<Image> {
}
