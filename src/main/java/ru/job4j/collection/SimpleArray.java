package ru.job4j.collection;

import java.util.*;

public class SimpleArray<T> implements Iterable<T> {
    //private int size;
    private T[] container = (T[]) new Object[10];
    public int index;
    public int modCount;

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return container[index];
    }

    public void add(T model) {

        /*if (index < container.length) {
            container[index] = model;

        } else {
            //container = Arrays.copyOf(container, container.length * 2);
            //size++;
            resize(model);
        }*/
        resize(model);
        container[index++] = model;
        modCount++;
    }

    private void resize(T model) {
        if (index == container.length) {
            container = Arrays.copyOf(container,
                    (container.length + 1) * 2);
        }
    }

    @Override
    public Iterator<T> iterator() {
        class Iterator1 implements Iterator<T> {
            int value = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                return index > value;
            }

            public T next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return container[value++];
                }
            }
        }

        return new Iterator1();

    }
}



/*это часть итератора, проверки на отличие от null*/
// это часть метода get() разные проверки на пустоту
//size = 10;
        /*if (index == 0 && container[index] != null) {
            return container[index];
        }*/
        /*for (int i = 0; i < size; i++) {
            if (container[i] == null) {
                return container[index];
            }
        }*/
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