package app.algorithms.filters.impl;

import app.algorithms.filters.ProductFilter;
import app.entities.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Сортирует список продуктов по популярности - общему числу просмотров
 */
public final class PopularProductFilter extends ProductFilter {
    private boolean ascending = false;

    public PopularProductFilter(boolean ascending) {
        this.ascending = ascending;
    }

    @Override
    public List<Product> applyOn(List<Product> unfiltered) {
        Map<Product, Integer> productsViews = new HashMap<>();
        unfiltered.sort(Comparator.comparingLong(Product::getId));
        unfiltered.forEach(p -> {
            if (productsViews.containsKey(p)) {
                Integer newCount = productsViews.get(p) + 1;
                productsViews.replace(p, newCount);
            } else {
                productsViews.put(p, 1);
            }
        });

        var comparator
                = ascending
                ? ascendingComparator()
                : descendingComparator();

        productsViews.entrySet().stream().sorted((Comparator<? super Map.Entry<Product, Integer>>) comparator);
        List<Product> productsByPopularity = new ArrayList<>();

        productsViews.entrySet().forEach(pv -> {
            productsByPopularity.add(pv.getKey());
        });

        return productsByPopularity;
    }

    /**
     * Сортировка по возрастанию популярности
     */
    private Comparator<Map.Entry<Product, Integer>> ascendingComparator() {
        return Map.Entry.comparingByValue();
    }

    /**
     * Сортировка по убыванию популярности
     */
    private Comparator<Map.Entry<Product, Integer>> descendingComparator() {
        return new Comparator<Map.Entry<Product, Integer>>() {
            @Override
            public int compare(Map.Entry<Product, Integer> o1, Map.Entry<Product, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        };
    }
}
