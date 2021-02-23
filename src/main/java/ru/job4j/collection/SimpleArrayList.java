package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleArrayList<E> {
    private Node<E> node; // тот самый лист со списком
    private int size = 0; //длина в LinkedList вроде как начинается тоже с нуля
    Node head = null; // начальный элемент в листе
    Node tail = null; // конечный элемент в листе пока не знаю нужен ли он? но по логике нужен,
    // так как значение должно быть "head, e , e , e, tail", у элементов позиции будут curr,
    // разные значения для каждого
    Node curr; // текущий элемент
    int modCount;

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;

            // фактически готовое добавление в конец списка
            /*transient int size = 0;
            transient Node<E> first;
            transient Node<E> last;

            void linkLast(E e) {
                final Node<E> l = last;
                final Node<E> newNode = new Node<>(l, e, null);
                last = newNode;
                if (l == null)
                    first = newNode;
                else
                    l.next = newNode;
                size++;
                modCount++;
            }*/
        }
    }

    public int getIndex(E model) {
        int index = 0;
        while (node.item == model) {
            index++;
        }
        return index;
    }

    public E get(int index) {
        E model = node.item;
        while (index == getIndex(model)) {
            model = (E) node.next;
        }
        return model;
    }

    public void add(E value) {
        // надо ли делать проверку value = null?
        // Её убрал так как пишет что эта проверка верна в любом случае
        curr = new Node(head, value, tail);
        Node newNode = new Node(curr.prev, value, curr.next);
        curr.next = newNode;
        curr = newNode;
        size++;
        modCount++;
    }

    public Iterator<E> iterator() {
        //получается перебераем с помощью get(value++)
        class Iterator1 implements Iterator<E> {
            int value = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                return value < size;
            }

            public E next() {
                if (modCount != expectedModCount) {
                    throw new ConcurrentModificationException();
                }
                if (!hasNext()) {
                    throw new NoSuchElementException();
                } else {
                    return get(value++);
                }
            }
        }

        return new Iterator1();

    }
}



