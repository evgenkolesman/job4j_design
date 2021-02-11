package ru.job4j.generics;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        //надо число вводить, придумать как сделать условие при наличии String.
        //Надо сделать чтобы id соответсвовало model, сложность в том что id это строка
        // а model это часть списка, то есть их значения не int/
        return model.equals(id);
    }

    @Override
    public boolean delete(String id) {
        // id строка это проблема
        return mem.remove(id);
    }

    @Override
    public T findById(String id) {
        T data = null;
        for (Iterator<T> it = mem.iterator(); it.hasNext();) {
            data = it.next();
            //return null;
        }
        return data;
    }
}
