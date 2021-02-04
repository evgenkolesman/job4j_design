package ru.job4j.generics;

import jdk.internal.jimage.ImageReader;

import java.util.Iterator;
import java.util.List;

// Каркас.

public class SimpleArray<T> implements Iterable<T> {

    public List<T> list;
    private T model;
    private int index=0;

    public SimpleArray() {
        this.list= list;
    }

    public static void main(String [] args) {
        SimpleArray sim = new SimpleArray();
        for (int i = 0; i < list.size(); i++) {
            new SimpleArray().add(list);
        }
        System.out.println(sim);
    }

    public void add(T model) {
        list.add(model);
    }

    public T set(int index, T model) {
        return list.set(index, model);
    }

    public void remove(int index) {
        list.remove(index);
        index++;
    }

    public void get(int index) {
        list.get(index);
    }

    public Iterator<T> iterator() {
        Object next = null;
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            next = it.next(); }
        return (Iterator<T>) next;
    }
}
