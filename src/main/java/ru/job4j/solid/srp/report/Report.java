package ru.job4j.solid.srp.report;

import ru.job4j.solid.srp.Employee;

import java.util.function.Predicate;

/*
 * отчеты интерфейс
 */
public interface Report {
    String generateReport(Predicate<Employee> filter);
}