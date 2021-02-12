package ru.job4j.generics;

import java.security.Key;

public class GenericsClass<K, V> {
    private K key;

    private V value;

    public GenericsClass(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public String toString() {
        return ("GenericClass" + "{Key= " + key
                + ",Value= " + value + "}");
    }

    public static void main(String[] arcs) {
        GenericsClass<String, String> gen = new GenericsClass<>("First key", "First value");
        System.out.println("Вывод в консоль: " + gen);

        GenericsClass<Integer, String> second = new GenericsClass<>(12345, "Second value");
        System.out.println("Вывод в консоль: " + second);
    }
}
