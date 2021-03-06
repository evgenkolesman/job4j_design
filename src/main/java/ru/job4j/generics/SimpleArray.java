package ru.job4j.generics;

import java.util.*;

// Каркас.
public class SimpleArray<T> implements Iterable<T> {

    private T[] array;
    private T model;
    private int size;

    // по конструктору пока есть вопросы
    public SimpleArray(int length) {
        this.array = (T[]) new Object[length];
        this.size = length;
        //this.array=array;
    }

    public int getSize() {
        return size;
    }

    public void add(T model) {
        array[size++] = model;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        return array[index];
    }

    public void set(int index, T model) {
        Objects.checkIndex(index, size);
        array[index] = model;
    }

    public void remove(int index) {
        //T arrayFinal = (T) new Object[array.length - 1];
        Objects.checkIndex(index, size);
        System.arraycopy(array, index, array, index + 1, array.length - index - 1);
        array[array.length - 1] = null;
        size--;

      // мой варик
        /*System.arraycopy(array, 0, arrayFinal, 0, size);
        int poz1 = index++;
        int poz2 = size - index;
        System.arraycopy(array, index, arrayFinal, poz2, poz2 - 1);
        //этим мы решаем проблемы сокращения длины
        array = (T[]) arrayFinal;*/
    }

    public Iterator<T> iterator() {

        class IteratorSA implements Iterator<T> {
            int value = 0;

            @Override
            public boolean hasNext() {
                return size > value;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return array[value++];
            }
        }

        return new IteratorSA();

    }
}
