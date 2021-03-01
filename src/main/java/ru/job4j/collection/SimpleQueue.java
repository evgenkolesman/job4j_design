package ru.job4j.collection;

//import java.util.NoSuchElementException;
//import java.util.Objects;

public class SimpleQueue<T> {
    private final SimpleStack<T> in = new SimpleStack<>();
    private final SimpleStack<T> out = new SimpleStack<>();
    private int index = 0;

    public T poll() {
        /*if (index == 0) {
            throw new NoSuchElementException();
        }
        int index1 = 0;
        if (index1 == 0)*/
            while (index != 0) {
                out.push(in.pop());
                index--;
                //index1++;
            }

        return out.pop();
        /*else {
            for (int i = 0; i < index; i++) {
                out.push(in.pop());
            }
        }*/
        /*T temp = null;
        if (index1 != 0) {
            temp = out.pop();
            index1--;
        }

        return temp;*/

    }

    public void push(T value) {
        in.push(value);
        index++;
        //out.push(value);
    }

    /*public boolean isEmpty() {
        SimpleStack <T> a = new SimpleStack<>();
        return a==null;
    }*/
}
