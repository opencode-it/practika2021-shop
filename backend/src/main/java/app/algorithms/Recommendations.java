package app.algorithms;

import app.entities.Product;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class Recommendations {
    @Autowired
    protected VisitRepository visits;

    @Autowired
    protected ProductRepository products;

    public abstract List<Product> getFor(Long accountID);



}
