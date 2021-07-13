package app.repositories.impl;

import app.entities.Feature;
import app.entities.Product;
import app.repositories.LongKeyRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends LongKeyRepository<Product> {

    //ToDo метод поиска по фичам
}
