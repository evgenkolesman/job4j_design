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
        while (column < data.length) {
            if (data[column] % 2 == 0) {
                break;
            }
            column++;
        }
        return column < data.length;
    }

    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException(); // это для исключений
        }
        return data[column++];
    }
}


 /* public boolean hasNext() {
        for (int i = column; i < data.length; i++) {
            // было     if (data[column] % 2 == 1) column++;
            //        return column < data.length;
            if (data[i] % 2 == 0) {
                return true;
            }
        }
        return false;
    }

    public Integer next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException(); // это для исключений
        }
        int data1 = data[column];
        if (data[column] % 2 == 0) {
            column++;
            return data1;
        } else {
            column++;
        return next();
        }
    }
}*/



