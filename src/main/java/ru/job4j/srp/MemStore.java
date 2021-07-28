package ru.job4j.srp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class MemStore implements Store {

    private final List<Employee> employees = new ArrayList<>();

    public void add(Employee em) {
        employees.add(em);
        //employees.stream().sorted(Comparator.comparing(Employee::getSalary));
        employees.sort(Comparator.comparing(Employee::getSalary));
        Collections.reverse(employees); // в принципе он и так сортирует
    }

    @Override
    public List<Employee> findBy(Predicate<Employee> filter) {
        return employees.stream().filter(filter).collect(Collectors.toList());
    }
}