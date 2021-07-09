package app.entities;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum ProductStatus {

    ARCHIVED,
    PUBLISHED,
    DELETED,
    WAIT_ACCEPTING;

}
