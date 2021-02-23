package ru.job4j.collection;

public class SimpleArrayList<E> {
    private Node<E> node;
    private int size; //его возможно надо найти
    Node head; // начальный элемент в листе
    Node tail; // конечный элемент в листе
    Node curr; // текущий элемент

    private class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(Node<E> prev, E element, Node<E> next) {
            this.item = element;
            this.next = next;
            this.prev = prev;
        }
    }

    public int getIndex() {
        int index = 0;
        for (node.item.equals()) {
            index++;
            return index;
        }
    }

    public E get(int index) {
        return node.item;
    }

    public void add(E value) {
        node = new Node(head, value, tail);
        if (curr != null) {
            Node newNode = new Node(curr.prev, value, curr.next);
            curr.next = newNode;
            curr = newNode;
        } else {
            head = tail = new Node(null, value, null);
            curr = head;
        }
    }
}*/
    /*public int getSize(E value) {
        if (head=null) {
            while () {

            }
        }
    }*/


