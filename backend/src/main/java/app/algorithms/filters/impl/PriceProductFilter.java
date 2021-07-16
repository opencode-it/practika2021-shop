package app.algorithms.filters.impl;

import app.algorithms.filters.ProductFilter;
import app.entities.Product;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Отбирает из списка продукты, находящиеся в указаном рендже
 */
public final class PriceProductFilter extends ProductFilter {
    private final BigDecimal minPrice;
    private final BigDecimal maxPrice;

    public PriceProductFilter(BigDecimal min, BigDecimal max) {
        this.minPrice = min;
        this.maxPrice = max;
    }

    @Override
    public List<Product> applyOn(List<Product> unfiltered) {
        return unfiltered.stream().filter(p ->
                IsInRange(p.getPrice(), minPrice, maxPrice))
                .collect(Collectors.toList());
    }

    private boolean IsInRange(BigDecimal price, BigDecimal min, BigDecimal max) {
        return price.compareTo(min)>=0 && price.compareTo(max)<=0;
    }
}
