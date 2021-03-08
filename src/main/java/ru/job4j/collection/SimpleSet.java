package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;

public class SimpleSet<T> implements Iterable<T> {
    int index = 0;
    private SimpleArray<T> container = new SimpleArray<>();
    /*public SimpleSet(SimpleArray<T>[] container1) {
        this.container1 = container1;
    }*/

    public boolean add(T model) {
        for (int i = 0; i < index; i++) {
            if (model.equals(container.get(i))) {
                return false;
            }
        }
        container.add(model);

        index++;
        //delEquals(container1);
        return true;
    }

    public Iterator<T> iterator() {
        return container.iterator();
    }
}
  /*  public SimpleArray[] delEquals(SimpleArray[] container) {
        for (int i = 0; i < container.length; i++) {
            Arrays.sort(container);
            if (container[i].equals(container[i + 1])) {
                System.arraycopy(container, i, container, i + 1, container.length - i - 1);
                container[container.length - 1] = null;
            }
        }
        return container;
    }*/

