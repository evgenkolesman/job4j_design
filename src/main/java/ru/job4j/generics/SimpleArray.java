package ru.job4j.generics;

import java.util.NoSuchElementException;

// Каркас.

public class SimpleArray<T> {

    private T[] array;
    private T model;
    private int index;

    public SimpleArray() {
        this.index = index;
        this.array=array;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            new SimpleArray().add(args);
        }
        System.out.println();
    }

    public int getSize() {
        return array.length;
    }

    public void add(T model) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
    }

    public void set(int index, T model) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
    }

    public Object remove(int index) {
        return index--;
    }

    public Object get(int index) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
        return array[index];
    }

    public boolean iterator (T[]array) { //пока ошибка в Итераторе

        public boolean hasNext() {
            return index < array.length;
        }

        public Integer next () {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data=array[index++];
            return data;
        }
    }

}