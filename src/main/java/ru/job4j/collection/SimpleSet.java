package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    private int index = 0;
    private final SimpleArray<T> container = new SimpleArray<>();

    public boolean add(T model) {
        if (container.contains(model)) {
            container.add(model);
            index++;
        }
        //этот код был написан для сортировки по возрастанию объектов, применять при необходимости
        //container.sort();

        return false;
    }

    public Iterator<T> iterator() {
        return container.iterator();
    }
}

