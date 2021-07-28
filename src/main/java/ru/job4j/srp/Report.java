package ru.job4j.srp;

import java.util.function.Predicate;

/*
 * отчеты интерфейс
 */
public interface Report {
    String generate(Predicate<Employee> filter);
}