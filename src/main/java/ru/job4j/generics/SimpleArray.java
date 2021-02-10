package ru.job4j.generics;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

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
        // тут можно применить Objects.checkIndex(index, size);
        /*if (index < array.length) {
            throw new IllegalStateException("Mistake");
        }*/
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
        /*for (int i = index; i < array.length; i++) {
            array[index] = array[index--];
        }*/
        /*if (index < 0 || index > array.length) {
            throw new IndexOutOfBoundsException();
        }*/
        Objects.checkIndex(index, size);
        int poz1 = index++;
        int poz2 = size - index;
        System.arraycopy(array, poz1, array, poz2, poz2);
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
    /*public static void main(String[] args) {// на до понять что я печатаю
        SimpleArray sim = new SimpleArray();
        //sim.printObject();
        sim.add();
        System.out.println();
    }*/

     /* public T iterator() {
                if (hasNext()) {
                    return array[value++];
                } else {
                    return throw new NoSuchElementException();
                }
            }*/
        /*public boolean hasNext() {
        return array.length > size;
    }*/

    /*public T next() {
        int index = 0;
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        T data = array[index++];
        return data;*/

    /*class IteratorSA<T> {
        public T iterator() {
            if (hasNext()) {
                return (T) next();
            } else {
                return null;
            }
        }
    }*/

    /*public Iterator<T> iterator() {
        if (hasNext()) {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return SimpleArray.this.hasNext();
                }

                @Override
                public T next() {
                    return (T) array [];
                }
            };
        } else {
            return null;
        }
    }*/

