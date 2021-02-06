package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;

// Каркас.
public class SimpleArray<T> {

    private T[] array;
    private T model;
    private int index;

    public SimpleArray(int index) {
        this.array = (T[]) new Object[index];
        //this.array=array;
    }

    /*public static void main(String[] args) {// на до понять что я печатаю
        SimpleArray sim = new SimpleArray();
        //sim.printObject();
        sim.set();
        System.out.println();
    }*/

    public void add(T model) {
        array[index] = model;
        index++;
    }

    public T get(int index) {
        return array[index];
    }

    public void set(int index, T model) {
        if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }
        set(index, model);
    }

    public int remove(int index) {
        for (int i = index; i < array.length; i++) {
            array[index] = array[index--];
        }
        return index;
    }


}
