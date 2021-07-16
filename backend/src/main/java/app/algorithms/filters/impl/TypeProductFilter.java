package app.algorithms.filters.impl;

import app.algorithms.filters.ProductFilter;
import app.entities.Product;
import app.entities.ProductType;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Показывает продукты только определенного типа
 */
public final class TypeProductFilter extends ProductFilter {
    private final ProductType typeFilter;

    public TypeProductFilter(ProductType typeFilter) {
        this.typeFilter = typeFilter;
    }

    @Override
    public List<Product> applyOn(List<Product> unfiltered) {
        return unfiltered.stream()
                .filter(p -> p.getType().equals(typeFilter))
                .collect(Collectors.toList());
    }
}
