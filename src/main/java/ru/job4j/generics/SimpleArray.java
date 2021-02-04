/*package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Каркас.

public class SimpleArray<T> {

    private T[] array;
    private T model;
    private int index;

    public SimpleArray() {
        this.index = index;
    }

    public static void main(String[] args) {
        for (int i = 0; i < args.length; i++) {
            new SimpleArray().add(args);
        }

        System.out.println();
    }

    public getSize() {
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

    public remove(int index) {
        return index--;
    }

    public get(int index) {
        if (index < array.length) {
            throw IllegalStateException("Mistake");
        }

        public Iterator<T> iterator (T[]array){
            this.array = array;
            public boolean hasNext () {
                return index < array.length;
            }

            public Integer next () {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[index++];
            }
        }
    }
*/