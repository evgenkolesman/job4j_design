package ru.job4j.srp;

import java.util.List;
import java.util.function.Predicate;

/*
 * хранилище интерфейс
 */
public interface Store {
    List<Employee> findBy(Predicate<Employee> filter);

    void sort();
}
