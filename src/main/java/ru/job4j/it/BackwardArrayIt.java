package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BackwardArrayIt implements Iterator<Integer> {
    private final int[] data;
    private int point = 0;

    public BackwardArrayIt(int[] data) {
    this.data = data;
    }

    public boolean hasNext() {
        return point < data.length;
    }

    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[data.length - 1 - point++];
    }
}
/*this.data = data;-варианты решения
return data.next(Arrays.sort(data, Comparator.reverseOrder())); - варианты решения
else for (int a= data.length-1;a>=point;a--) {
return data[data.length - 1 - point++ ];

}- варианты решения не верные*/
