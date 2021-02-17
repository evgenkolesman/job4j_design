package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArray<T> implements Iterable<T> {
    private Object[] container = new Object[10];
    public T[] containerNew = (T[]) container;
    private int size;
    public int index;
    public int modCount;

    public SimpleArray() {
        //this.containerNew = containerNew;
        size = container.length;
    }

    public int getmodCount() {
        // изменилось или длина, или значение одного из элемента массива
        for (int i = 0; i < containerNew.length; i++) {
            if (size != containerNew.length) {
                modCount++;
            } else if (!(containerNew[i] == container[i])) {
                modCount++;
            }
        }
        return modCount;
    }

    public T get(int index) {
        if (containerNew[index] == null) {
            throw new IndexOutOfBoundsException();
        }
        Objects.checkIndex(index, size);
        return (T) containerNew[index];
    }

    public void add(T model) {
        if (index < containerNew.length) {
            containerNew[index] = model;
        } else {
            size++;
            containerNew[size--] = model;
        }

    }

    @Override
    public Iterator<T> iterator() {
        //private int expectedModCount = modCount;
        class Iterator1 implements Iterator<T> {
            int value = 0;
            private final int expectedModCount = getmodCount();

            public boolean hasNext() {
                return size > value && containerNew[value] != null;
            }

            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (getmodCount() != expectedModCount) {
                    throw new ConcurrentModificationException();
                } else {
                    //T data = containerNew[value++];
                    return containerNew[value++];
                }
            }
        }

        return new Iterator1();

    }
}

