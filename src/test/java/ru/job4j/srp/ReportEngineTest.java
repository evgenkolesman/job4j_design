package ru.job4j.srp;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

/*
 * Тест
 * основа производства изменений TDD,
 * начинаем с тестов
 */
public class ReportEngineTest {

    @Test
    public void whenNewGeneratedThree() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan", 100);
        Employee worker2 = new Employee("Semen", 1000);
        Employee worker3 = new Employee("Alex", 99);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportEngine(store);
        StringBuilder heading = new StringBuilder().append("Name; Salary;").append(System.lineSeparator());
        var expect1 = new StringBuilder()
                .append(worker.getName()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        var expect2 = new StringBuilder()
                .append(worker2.getName()).append(";")
                .append(worker2.getSalary()).append(";")
                .append(System.lineSeparator());
        var expect3 = new StringBuilder()
                .append(worker3.getName()).append(";")
                .append(worker3.getSalary()).append(";")
                .append(System.lineSeparator());

        assertThat(engine.generate(em -> true), is(String.format("%s%s%s%s", heading, expect2, expect1, expect3)));
    }

}