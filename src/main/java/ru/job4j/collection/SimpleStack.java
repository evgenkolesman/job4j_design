package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        return linked.deleteFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }

    public boolean isEmpty() {
        return linked.isEmpty();
    }

    // не верно, наличие у Стэка такой функции
    /*public void pushEnd(T value) {
        linked.add(value);
    }*/
}
