package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.function.Predicate;

public class ListUtils {

    public static <T> void addAfter(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index + 1) {
                i.add(value);
                break;
            }
            i.next();
        }
    }

    public static <T> void addBefore(List<T> list, int index, T value) {
        Objects.checkIndex(index, list.size());
        ListIterator<T> i = list.listIterator();
        while (i.hasNext()) {
            if (i.nextIndex() == index) {
                i.add(value);
                //list.size()++;
                break;
            }
            i.next();
        }
    }

    public static <T> void removeIf(List<T> list, Predicate<T> filter) {

        //ListIterator<T> i = list.listIterator();
        //T value = (T) list;
        int index = 0;
        Iterator<T> each = list.iterator();
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                index++;
                each.next();
                //return list;
            } else {
                list.remove(each.next());
                break;
            }
        }
        //return list;
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        Iterator<T> each = list.iterator();
        int index = 0;
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.next();
                index++;
            } else {
                list.set(index, value);
                break;
            }
        }
        //return list;

    }

    public static <T> void removeAll(List<T> list, List<T> elements) {
        ListIterator<T> a = elements.listIterator();
        ListIterator<T> i = list.listIterator();
        //int index = 0;
        while (i.hasNext() && a.hasNext()) {
            //ListIterator<T> a1 = elements.listIterator();
            //a = a1;
                if (i.next().equals(a.next())) {
                    list.remove(a.next());
                    elements.remove(a.next());
                    //index--;
                    //break;
                    //i.next();
                }
            a.next();
                //i.next();
                //index++; // Индекс нужен был для get()
        }
    }
}
         /*int index = 0;
        while (list.size() >= elements.size()) {
            for (int i = 0; i < list.size(); i++) {
                for (int a = 0; a < list.size(); a++) {
                    while (list.get(i).equals(elements.get(a))) {
                        list.remove(i);
                        elements.remove(a);
                    }
                }
            }
        }*/
//list.remove(index);




