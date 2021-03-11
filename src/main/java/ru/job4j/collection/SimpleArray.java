package ru.job4j.collection;

import java.util.*;

import static java.lang.String.valueOf;

public class SimpleArray<T> implements Iterable<T> {
    //private int size;
    private T[] container = (T[]) new Object[10];
    private int index;
    private int modCount;

    public T get(int index) {
        Objects.checkIndex(index, this.index);
        return container[index];
    }

    public SimpleArray[] add(T model) {
        resize();
        container[index++] = model;
        modCount++;
        return new SimpleArray[0];
    }

    private void resize() {
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

    public boolean contains(T model) {
        for (int i = 0; i < index; i++) {
            if (model.equals(container[i])) {
                return false;
            }
        }
        return true;
    }
}









/*public void sort() {
        Arrays.sort(container, Comparator.comparing(String::valueOf));
    }
}*/



        /*Начальный вариант

        Arrays.sort(container, new Comparator<T>() {
            public int compare(T o1, T o2) {
                return valueOf(o1).compareTo(valueOf(o2));
            }
        });
        Вариант Лямбда
        Arrays.sort(container, (o1, o2) -> valueOf(o1).compareTo(valueOf(o2)));
        Вариант Comparator comparing
        Arrays.sort(container, Comparator.comparing(String::valueOf));
        */







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

 /*if (index < container.length) {
            container[index] = model;
        } else {
            //container = Arrays.copyOf(container, container.length * 2);
            //size++;
            resize(model);
        }*/