package ru.job4j.collection;

//import java.util.NoSuchElementException;
//import java.util.Objects;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int index = 0;

    public T poll() {
            while (index != 0) {
                out.push(in.pop());
                index--;
                //index1++;
            }

        return out.pop();
    }

    public void push(T value) {
        in.push(value);
        index++;
        //out.push(value);
    }
}
