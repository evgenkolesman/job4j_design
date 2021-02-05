package ru.job4j.generics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Generics {

    public static void main(String[] args) {
        Generics gen = new Generics();
        List<Animal> first = new ArrayList<>();
        List<Predator> second = new ArrayList<>();
        List<Tiger> third = new ArrayList<>();

        String name = "name";
        first.add(new Animal(name));
        second.add(new Predator(name));
        third.add(new Tiger(name));

        gen.printObject(first);
        gen.printObject(second);
        gen.printObject(third);
        System.out.println();

        //gen.printBoundedWildCard(first);
        gen.printBoundedWildCard(second);
        gen.printBoundedWildCard(third);
        System.out.println();

        gen.printLowerBoundedWildCard(first);
        gen.printLowerBoundedWildCard(second);
        //gen.printLowerBoundedWildCard(third);

    }

    public void printObject(List<?> list) {
        for (Iterator<?> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент" + next);
        }
    }

    // должно быть extends
    public void printBoundedWildCard(List<? extends Predator> list) {
        for (Iterator<? extends Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент" + next);
        }
    }

    // должно быть super но не заходит
    public void printLowerBoundedWildCard(List<? super Predator> list) {
        for (Iterator<? super Predator> it = list.iterator(); it.hasNext();) {
            Object next = it.next();
            System.out.println("Текущий элемент" + next);
        }
    }
}
