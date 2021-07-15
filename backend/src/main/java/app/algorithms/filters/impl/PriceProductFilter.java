package app.algorithms.filters.impl;

import app.algorithms.filters.ProductFilter;
import app.entities.Product;

import java.math.BigDecimal;
import java.util.List;

/**
 * Отбирает из списка продукты, находящиеся в указаном рендже
 */
public class PriceProductFilter extends ProductFilter {
    private BigDecimal minPrice;
    private BigDecimal maxPrice;

    public PriceProductFilter(BigDecimal min, BigDecimal max) {
        this.minPrice = min;
        this.maxPrice = max;
    }

    @Override
    public List<Product> applyOn(List<Product> unfiltered) {
        return null;
    }
}
