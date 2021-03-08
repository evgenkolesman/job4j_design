package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleSet extends SimpleArray {
    private Object[] container1 = (Object[]) container;

    public void add(Object model) {
        Arrays.sort(container1);
        super.add(model);
        delEquals(container1);
    }

    public Iterator<Object> iterator() {
        return iterator();
    }
}
