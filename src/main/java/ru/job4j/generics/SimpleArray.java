package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Каркас.
public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private T model;
    private int size = 0;

    // по конструктору пока есть вопросы
    public SimpleArray(int length) {
        this.array = (T[]) new Object[length];
        //this.array=array;
    }

    @SuppressWarnings("checkstyle:InnerAssignment")
    public int getSize() {
        return size = array.length;
    }

    /*public static void main(String[] args) {// на до понять что я печатаю
        SimpleArray sim = new SimpleArray();
        //sim.printObject();
        sim.add();
        System.out.println();
    }*/

    public void add(T model, int index) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
        array[index] = model;
        index++;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T model) {
        array[index] = model;
    }

    public void remove(int index) {
        /*for (int i = index; i < array.length; i++) {
            array[index] = array[index--];
        }*/
        if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }
        System.arraycopy(array, index + 1, array, index, size - 1);
    }

    public boolean hasNext() {
        return array.length > size;
    }

    public T next() {
        int index = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T data = array[index++];
        return data;
    }

    @Override
    public Iterator<T> iterator() {
        if (hasNext()) {
            return (Iterator<T>) next();
        } else {
            return null;
        }
    }
}
