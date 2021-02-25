package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleArrayList<E> {
    private Node<E> node; // тот самый лист со списком
    private int size = 0; //длина в LinkedList вроде как начинается тоже с нуля
    private Node head = null; // начальный элемент в листе
    private Node tail = null; // конечный элемент в листе пока не знаю нужен ли он? но по логике нужен,
    // так как значение должно быть "head, e , e , e, tail", у элементов позиции будут curr,
    // разные значения для каждого
    private Node curr; // текущий элемент
    private int modCount;

    private class Node<E> {
        E item;
        Node<E> next;
        //Node<E> prev;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
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
        }
    }

    // мы перебираем, различные элементы списка и сравниваем их,
    public int getIndex(E model) {
        for (int i = 0; i < size; i++) {
            //сравнение node.item (элемент списка node) с заявленным элементом model
            if (node.item.equals(model)) {
                return i;
            }
        }
        //если нет совпадений кидаем что нет такого элемента
        throw new NoSuchElementException();
    }

    public E get(int index) {
        // можно сделать this.index вместо size этим ограничиться,
        // но тогда index должен быть приватным полем.
        Objects.checkIndex(index, size);
        //сравниваю index входящий и индексы элементов списка, осуществляю перебор путем обращения
        // к node.next - следующий элемент списка.
        while (index == getIndex(node.item)) {
            node.item = (E) node.next;
        }
        return node.item;
    }

    public void add(E value) {
        // надо ли делать проверку value != null?
        // Её убрал так как пишет что эта проверка верна в любом случае
        curr = new Node(value, tail);
        Node newNode = new Node(value, curr.next);
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



