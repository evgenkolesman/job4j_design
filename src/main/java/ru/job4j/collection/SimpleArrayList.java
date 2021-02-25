package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<E> {
    private Node<E> node; // тот самый лист со списком
    private int count = 0; // количество элементов списка
    private Node head = null; // ссылка на голову
    private int modCount = 0; // число изменений

    private class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
            //this.prev = prev;
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

    // мы перебираем, различные элементы списка и сравниваем их,
    public int getIndex(E model) {
        for (int i = 0; i < count; i++) {
            //сравнение node.item (элемент списка node) с заявленным элементом model
            if (node.item.equals(model)) {
                return i;
            } else {
                node.item = (E) node.next;
            }
        }
        //если нет совпадений кидаем что нет такого элемента
        throw new NoSuchElementException();
    }

    public E get(int index) {
        // можно сделать this.index вместо size этим ограничиться,
        // но тогда index должен быть приватным полем.
        Objects.checkIndex(index, count);
        //сравниваю index входящий и индексы элементов списка, осуществляю перебор путем обращения
        // к node.next - следующий элемент списка.
        while (index == getIndex(node.item)) {
            node.item = (E) node.next;
        }
        return node.item;
    }

    public void add(E value) {
        count++;
        Node<E> node = new Node<>(value, null);
        if (head == null) {
            head = node;
            return;
        }

        Node<E> tail = head;
        while (tail.next != null) {
            tail = head.next;
        }
        tail.next = node;
        modCount++;
    }

    public Iterator<E> iterator() {
        //получается перебераем с помощью get(value++)
        class Iterator1 implements Iterator<E> {
            int value = 0;
            private final int expectedModCount = modCount;

            public boolean hasNext() {
                return value < count;
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



