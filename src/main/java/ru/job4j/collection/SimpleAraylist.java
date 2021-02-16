package ru.job4j.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;


public class SimpleAraylist<T> implements Iterable<T> {
    private final Object[] container = new Object[10];
    private int size;

    public SimpleAraylist () {
        this.container=container;
        size=container.length;
    }
    public T get(int i) {
        Objects.checkIndex(i,container.length);
        return (T) container[i];
        }

    public void add(T model) {
        size++;

    }

    public Iterator<T> iterator() {

    return null;
    }
}
