package ru.job4j.collection;

//import java.util.NoSuchElementException;
//import java.util.Objects;

import java.util.NoSuchElementException;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int index = 0;
    private int index1 = 0;

    public T poll() {
        if (index == 0) {
            throw new NoSuchElementException();
        }
        if (index1 == 0) {
            while (index != 0) {
                out.push(in.pop());
                index--;
                index1++;
            }
        }

        T temp = null;
        if (index1 != 0) {
            temp = out.pop();
            index1--;
        }
        //return out.pop();
        return temp;
    }

    public void push(T value) {
        in.push(value);
        index++;
        //out.push(value);
    }
}
