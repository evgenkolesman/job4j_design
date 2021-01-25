package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class MatrixIt implements Iterator<Integer> {
    private final int[][]data; // убрал final так как выдает в дальнейшем ошибку
    private int row=0;
    private int column=0;
    public MatrixIt(int[][] data) {
        this.data = data;
    }
    public boolean hasNext(){
     if (row < data.length&& column < data[row].length){
         while (row <= data.length && column>=data[row].length) // это для исключения пустых частей
         row=0;
         column++;
     return (row < data.length && column < data[row].length);}
     else
         return false;
    }

     public Integer next() // включаем перербор
        {
            if(!hasNext())
            {
                throw new NoSuchElementException(); // это для исключений
            }
            int data1 = data[row][column];
            column++;
     return data1;
        }
}
         /*return true;
         }
    else
        return false; // это по условиям задачи, но есть вариант сократить просто
     //return (row < data.length && column < data[row].length); - думаю вот так
    }
    public Integer next() // включаем перербор
    {
        if(!hasNext())
        {
            throw new NoSuchElementException(); // это для исключений
        }
        int data1 = data[row][column];
        column++;
        /*while (row <= data.length && column>=data[row].length) // это для исключения пустых частей
        {
            row=0;
            column++;
        }*/
      // было return data1ж
