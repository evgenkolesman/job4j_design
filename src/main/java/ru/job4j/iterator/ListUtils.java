package ru.job4j.iterator;

import java.util.*;
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
        Iterator<T> each = list.iterator();
        while (each.hasNext()) {
            T next = each.next();
            if (filter.test(next)) {
                each.remove();
            }
        }
    }

    public static <T> void replaceIf(List<T> list, Predicate<T> filter, T value) {
        Iterator<T> each = list.iterator();
        int index = 0;
        while (each.hasNext()) {
            if (filter.test(each.next())) {
                each.next();
                list.set(index, value);
                break;
            } else {
                index++;
            }
        }
    }

    // реализовал метод удаления если массив надо удалять и сравнивать при услвии,
    // что в массиве числа рсположены по порядкупо порядку, просто писать этот метод под разнобой,
    // я бы применил метод sort() и потом прогнал через свой метод

    public static <T> void removeAll(List<T> list, List<T> elements) {
        int index = 0;
        ListIterator<T> a = elements.listIterator();
        //ListIterator<T> i = list.listIterator();
        //while (index < elements.size()) {
        while (a.hasNext()) {
            //T list1 = list.get(index);
            T element = a.next();
            removeIf(list, e -> e.equals(element));
        }
    }
}
       /*else {
                index++;
                T list1 = list.get(index);
                //T list1 = i.next();
                if (list1.equals(a.next())) {
                    list.remove(list1);
                    //a.next();
                    //index = 0;
                }
            }*/
//list.removeAll(elements);







