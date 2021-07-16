package app.algorithms.recommendations.comparators;

import app.entities.ProductFeature;

import java.util.Comparator;
import java.util.Map;

/**
 * Нужен для сравнения Мапы ЧтоУгодно->ЧастотаПросмотра
 * Сортирует частоте просмотров, отображенные
 * значением Integer
 */
public final class DescendingRateComparator<A> implements Comparator<Map.Entry<A, Integer>> {
    @Override
    public int compare(Map.Entry<A, Integer> o1, Map.Entry<A, Integer> o2) {
        return o2.getValue().compareTo(o1.getValue());
    }
}
