package ru.job4j.srp.report;

import ru.job4j.srp.Employee;

import java.util.function.Predicate;

/*
 * отчеты интерфейс
 */
public interface Report {
    String generateIT(Predicate<Employee> filter);

    String generateHR(Predicate<Employee> filter);

    String generateBuh(Predicate<Employee> filter);
}