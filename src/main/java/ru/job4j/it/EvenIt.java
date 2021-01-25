package ru.job4j.it;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class EvenIt implements Iterator <Integer>{
    //Iterator it = new EvenIt (new int[] {4, 2, 1, 1});
    private final int [] data;
    public EvenIt (int [] data){
        this.data=data;
    }

    public boolean hasNext() {
        for (int i = 0; i <= data.length; i++) {
            if (data[i] % 2 == 0){
                return true;}
                else return false;
    }


    public Integer next() {
        if(!hasNext())
        {
            throw new NoSuchElementException(); // это для исключений
        }

            return data[];
    }

}
