package ru.job4j.collection;

import java.util.Iterator;
import java.util.Objects;

public class SimpleSet<T> implements Iterable<T> {
    private int index = 0;
    private final SimpleArray<T> container = new SimpleArray<>();

    public boolean add(T model) {
        if (Objects.equals(container, model)) {
            //этот код был написан для сортировки по возрастанию объектов, применять при необходимости
            //container.sort();
            return false;
        }
        container.add(model);
        index++;
        return true;
    }

    public Iterator<T> iterator() {
        return container.iterator();
    }
}

