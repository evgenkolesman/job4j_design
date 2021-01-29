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
        //while (column < data.length) {
        if (data[column] % 2 == 1) {
            column++;
        }
        return column < data.length;
    }

    public Integer next() {
        if (!hasNext()) {
            //if (column >= data.length) {
            throw new NoSuchElementException(); // это для исключений
        }
        return data[column++];
    }
}








