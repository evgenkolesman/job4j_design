package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator<Integer> {

    Iterator it = new EvenIt(new int[]{4, 2, 1, 1});

    private int[] data;
    private int column = 0;

    public EvenIt(int[] data) {
        this.data = data;
    }

    public boolean hasNext() {
        if ((data[column] % 2) == 0 && column < data.length) {
        column++;
            return true;
        } else {
            return false;
        }
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException(); // это для исключений
        }
        //data [column];
        column++;
        return data[column];
    }
}


