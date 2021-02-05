/*package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Каркас.

public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private T model;
    private int index;

    public SimpleArray() {
        this.index = index;
        //this.array=array;
    }

    public static void main(String[] args) {// на до понять что я печатаю
        SimpleArray sim = new SimpleArray();
        sim.printObject();
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

    public int remove(int index) {
        index--;
        return remove(array[index]);
    }

    public T get(T[] array) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
        return array[index];
    }

    public void printObject(T[] array) {
        for (Iterator<T> it = array.iterator(); it.hasNext(); ) {
            Object next = it.next();
            System.out.println("Текущий элемент" + next);
        }

        public Iterator<T> iterator () { //пока ошибка в Итераторе
            public boolean hasNext () {
                return false;
            }

            public Integer next () {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return iterator.next();
            }
        }
    }
}*/
    /*@Override
    public Iterator<T> iterator() {
        return null;
    }*/
