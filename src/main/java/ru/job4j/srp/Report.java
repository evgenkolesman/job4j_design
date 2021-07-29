package ru.job4j.srp;

import java.util.function.Predicate;

/*
 * отчеты интерфейс
 */
public interface Report {
    String generateIT(Predicate<Employee> filter);

    String generateHR(Predicate<Employee> filter);

    String generateBuh(Predicate<Employee> filter);
}