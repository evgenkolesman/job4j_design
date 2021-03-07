package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class SimpleSet extends SimpleArray {
    private Objects[] container1 = (Objects[]) container;

    @Override
    public void add(Object model) {
        Arrays.sort(container1);
        super.add(model);
        delEquals(container1);

    }

    public Iterator<Object> iterator() {
        return iterator();
    }
}
