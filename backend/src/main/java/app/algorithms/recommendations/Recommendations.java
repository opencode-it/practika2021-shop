package app.algorithms.recommendations;

import app.entities.Product;
import app.entities.Visit;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public abstract class Recommendations {
    @Autowired
    private VisitRepository visits;

    @Autowired
    private ProductRepository products;

    public abstract List<Product> getFor(Long accountID);

    protected List<Product> products() {
        return products.findAll();
    }

    protected List<Visit> visitsOf(Long accountId) {
        return visits.findByAccountId(accountId).get();
    }

}
