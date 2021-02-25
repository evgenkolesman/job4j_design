package ru.job4j.collection;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class ForwardLinked<T> implements Iterable<T> {
    private Node head;
    public int size = 0;

    private static class Node<T> {
        Node next;
        T value;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    public void add(T value) {
        Node<T> node = new Node<T>(value, null);
        if (head == null) {
            head = node;
            return;
        }
        Node<T> tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }
        tail.next = node;
        size++;
    }

    public T deleteFirst() {
        Node<T> prev = head;
        if (prev == null) {
            throw new NoSuchElementException();
        } else {
            final T value1 = prev.value;
            Node<T> a = prev.next;
            prev.value = null;
            prev.next = null;
            head = a;
            size--;
            return value1;
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> node = head;

            @Override
            public boolean hasNext() {
                return node != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T value = node.value;
                node = node.next;
                return value;
            }
        };
    }
}