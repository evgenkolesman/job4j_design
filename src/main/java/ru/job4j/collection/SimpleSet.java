package ru.job4j.collection;

import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    int index = 0;
    private final SimpleArray<T> container = new SimpleArray<>();

    public boolean add(T model) {
        for (int i = 0; i < index; i++) {
            if (model.equals(container.get(i))) {
                return false;
            }
        }
        container.add(model);
        index++;
        //container.sort();
        return true;
    }

    public Iterator<T> iterator() {
        return container.iterator();
    }
}

