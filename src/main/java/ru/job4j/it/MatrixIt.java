package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

/*public class MatrixIt implements Iterator<Integer> {
    private final int[][] data; // убрал final так как выдает в дальнейшем ошибку
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    public boolean hasNext() {
        return (row < data.length && column < data[row].length);
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int data1 = data[row][column];
        column++;
        while (row < data.length && column >= data[row].length) {
            row = 0;
            column++;
        }
        return data1;
    }
}*/

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data; // убрал final так как выдает в дальнейшем ошибку
    private int row = 0;
    private int column = 0;
    private int size;
    private int poz = 0;
    int[] a = {};

    public MatrixIt(int[][] data) {
        this.data = data;
        this.size = countEl(data);
    }

    public int countEl(int[][] data) {
        int count = 0;
        for (int[] row : data) {
            count += row.length;
        }
        return count;
    }

    public boolean hasNext() {
        return (poz < size);
    }
    /*public boolean hasNext() {
        while (data.length > row && column == data[row].length) {
            column = 0;
            row++;

        }
        return data.length > row && data[row].length > column;
    }*/

    public Integer next() {
        if (poz >= size) {
            throw new NoSuchElementException();
        }
        if (column == data[row].length && row < data.length) {
            row++;
            column = 0;
            return data[row][column];
        }
        int data1 = data[row][column];
        //column++;
        return data1;
    }
}


