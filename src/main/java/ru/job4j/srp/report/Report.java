package ru.job4j.srp.report;

import ru.job4j.srp.Employee;

import java.util.function.Predicate;

/*
 * отчеты интерфейс
 */
public interface Report {
    String generateReport(Predicate<Employee> filter);
}