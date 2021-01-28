package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    //Iterator it = new EvenIt(new int[]{4, 2, 1, 1});

    private final int[] data;
    private int column = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        // ограничиваем по четности,
        // по размеру не надо так как всегда true.
        return data[column] % 2 == 0;
    }
    //else return false;

    public Integer next() {
        if (column >= data.length) {
            throw new NoSuchElementException(); // это для исключений
        }
        //data [column];
        column++;
        return data[column];
    }
}







