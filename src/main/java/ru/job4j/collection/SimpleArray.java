package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container = (T[]) new Object[10];
    //public T[] containerNew = (T[]) container;
    private int size = 10;
    public int index;
    public int modCount;

    /*public SimpleArray() {
        size = 10;
    }*/

    /*public int getmodCount() {
        // изменилось или длина, или значение одного из элемента массива
        for (int i = 0; i < containerNew.length; i++) {
            if (size != containerNew.length) {
                modCount++;
            } else if (!(containerNew[i] == container[i])) {
                modCount++;
            }
        }
        return modCount;
    }*/

    public T get(int index) {
        if (container[index] == null) {
            throw new IndexOutOfBoundsException();
        }
        Objects.checkIndex(index, size);
        return container[index--];
    }

    public void add(T model) {
        if (index < container.length) {
            container[index] = model;
            modCount++;
        } else if (index == container.length) {
            Arrays.copyOf(container, container.length + 1);
            //size++;
            container[index++] = model;
            modCount++;
            //container[size--] = model;
        }

    }

    @Override
    public Iterator<T> iterator() {
        //private int expectedModCount = modCount;
        class Iterator1 implements Iterator<T> {
            int value = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                return size > value && container[value] != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                } else {
                    //T data = containerNew[value++];
                    return container[value++];
                }
            }
        }

        return new Iterator1();

    }
}

