package ru.job4j.kiss;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class MaxMin {
    public <T> T max(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = a -> a < 0;
        return getT(value, comparator, predicate);
    }

    public <T> T min(List<T> value, Comparator<T> comparator) {
        Predicate<Integer> predicate = a -> a > 0;
        return getT(value, comparator, predicate);

    }

    private <T> T getT(List<T> value, Comparator<T> comparator, Predicate<Integer> predicate) {
        T v = value.get(0);
        for (int i = 0; i < value.size() - 1; i++) {
            if (predicate.test(comparator.compare(v, value.get(i + 1)))) {
                v = value.get(i + 1);
            }
        }
        return v;
    }
}
