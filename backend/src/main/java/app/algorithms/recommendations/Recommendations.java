package app.algorithms.recommendations;

import app.entities.Product;
import app.entities.ProductFeature;
import app.entities.ProductType;
import app.entities.Visit;
import app.repositories.impl.ProductRepository;
import app.repositories.impl.VisitRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public abstract class Recommendations {
    @Autowired
    private VisitRepository visits;

    @Autowired
    private ProductRepository products;

    private ProductType typeFilter;
    private Set<ProductFeature> commonFeatureFilter;
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    protected Recommendations(ProductType type, Set<ProductFeature> feature, ) {

    }





    public abstract List<Product> getFor(Long accountID);

    protected List<Visit> visitsOf(Long accountId) {
        return visits.findByAccountId(accountId).get();
    }

    protected List<Product> allProducts(Iterable<ProductFeature> featureFilter) {
        return products.findByFeaturesIn(featureFilter);
    }

    protected List<Product> allProducts(List<Product> productsList, Iterable<ProductFeature> featureFilter) {
        return productsList.stream().filter(p -> {
            //TODO Попросить Кирилла использовать Set вместо листа в сущностях :<
            p.getFeatures().
        });
    }

    protected List<Product> filteredByPrice(BigDecimal minPrice, BigDecimal maxPrice) {
        return null;
    }

    protected List<Product> filteredByPrice(List<Product> productsList, BigDecimal minPrice, BigDecimal maxPrice) {
        return productsList.stream().filter(p -> {
            return IsInRange(p.getPrice(), minPrice, maxPrice);
        }).collect(Collectors.toList());
    }
    private boolean IsInRange(BigDecimal price, BigDecimal min, BigDecimal max) {
        return price.compareTo(min)>=0 && price.compareTo(max)<=0;
    }

    protected List<Product> filterByPopularity(List<Product> productsList) {
        productsList.sort(Comparator.comparing(Product::getId));
        return productsList.stream().distinct().collect(Collectors.toList());
    }
}
