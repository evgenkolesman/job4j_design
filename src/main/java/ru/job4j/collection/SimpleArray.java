package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    private T[] container = (T[]) new Object[10];
    //private int size = 10;
    public int index;
    public int modCount;

    public T get(int index) {
        if (index == 0 && container[index] != null) {
            return container[0];
        }
        Objects.checkIndex(index, this.index);
        return container[index];
    }

    public void add(T model) {
        if (index < container.length) {
            container[index] = model;
            modCount++;
        } else if (index == container.length) {
            Arrays.copyOf(container, container.length * 2);
            //size++;
            container[index++] = model;
            modCount++;
        }
    }

    @Override
    public Iterator<T> iterator() {
        class Iterator1 implements Iterator<T> {
            int value = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                if (index == value && container[index] != null) {
                    return true;
                }
                return index > value;
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

// не нужен конструктор и счетчик
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