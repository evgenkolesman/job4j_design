package ru.job4j.generics;

import java.util.List;
import java.util.ArrayList;
import java.util.NoSuchElementException;

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
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.set(index, model);
        return true;
    }

    @Override
    public boolean delete(String id) {
        // id строка это проблема
        int index = indexOf(id);
        if (index == -1) {
            return false;
        }
        mem.remove(index);
        return true;
    }

    @Override
    public T findById(String id) {
        int index = indexOf(id);
        if (index == -1) {
            throw new NoSuchElementException();
        }
        return mem.get(index);
    }

    public int indexOf(String id) {
        int index = -1;
        for (int i = 0; i < mem.size(); i++) {
            if (mem.get(i).getId().equals(id)) {
                index = i;
                break;
            }
        }
        return index;
    }
}



/* public int indexOf(String id) {
   for (T model : mem) {
    String id1 = model.getId();
    if (id1.equals(id)) {
    return indexOf(id);
    } else {
    return -1;
    }*/
//итератор
 /*T data = null;
        //for (T t : mem) если hasNext() не нужен
        for (Iterator<T> it = mem.iterator(); it.hasNext();) {
            data = it.next();
            //return null;
        }*/