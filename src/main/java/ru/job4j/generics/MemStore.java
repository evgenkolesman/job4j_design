package ru.job4j.generics;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import java.util.Objects;

public class MemStore<T extends Base> implements Store<T> {
    private final List<T> mem = new ArrayList<>();

    @Override
    public void add(T model) {
        mem.add(model);
    }

    @Override
    public boolean replace(String id, T model) {
        //надо число вводить, придумать как сделать условие при наличии String.
        if (Objects.checkIndex(Integer.parseInt(id), mem.size())){

            return model.getId(Integer.parseInt(id)); }
        else
            //System.arraycopy(mem, id, model, id - 1);
            return false;
    }

    @Override
    public boolean delete(String id) {
        if (Objects.checkIndex(Integer.parseInt(id), mem.size())) {
            return mem.remove(id);
        } else {
            return (throw new IndexOutOfBoundsException());
        }
    }

    @Override
    public T findById(String id) {
        for (Iterator<T> it = mem.iterator(); it.hasNext(); ) {
            return it.next();
        }

        return it.next;

    }
}
