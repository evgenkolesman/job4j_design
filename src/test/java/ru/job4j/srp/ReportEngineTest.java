package ru.job4j.srp;

import org.junit.Test;
import ru.job4j.srp.report.Report;
import ru.job4j.srp.report.ReportBUH;
import ru.job4j.srp.report.ReportHR;
import ru.job4j.srp.report.ReportIT;
import ru.job4j.srp.store.MemStore;

import java.util.Calendar;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertThat;

/*
 * Тест
 * основа производства изменений TDD,
 * начинаем с тестов
 */
public class ReportEngineTest {

    @Test
    public void whenNewGeneratedThreeHR() {
        MemStore store = new MemStore();
        Employee worker = new Employee("Ivan", 100);
        Employee worker2 = new Employee("Semen", 1000);
        Employee worker3 = new Employee("Alex", 99);
        store.add(worker);
        store.add(worker2);
        store.add(worker3);
        Report engine = new ReportHR(store);
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

        assertThat(engine.generateReport(em -> true), is(String.format("%s%s%s%s", heading, expect2, expect1, expect3)));
    }

    @Test
    public void whenGeneratedBUH() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportBUH(store);
        StringBuilder heading = new StringBuilder().append("Name; Hired; Fired; Salary;");
        StringBuilder expect = new StringBuilder()
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertThat(engine.generateReport(em -> true), is((heading.append(expect).toString())));
    }

    @Test
    public void whenGeneratedIT() {
        MemStore store = new MemStore();
        Calendar now = Calendar.getInstance();
        Employee worker = new Employee("Ivan", now, now, 100);
        store.add(worker);
        Report engine = new ReportIT(store);
        StringBuilder expect = new StringBuilder()
                .append("Name; Hired; Fired; Salary;")
                .append(System.lineSeparator())
                .append(worker.getName()).append(";")
                .append(worker.getHired()).append(";")
                .append(worker.getFired()).append(";")
                .append(worker.getSalary()).append(";")
                .append(System.lineSeparator());
        assertNotEquals(engine.generateReport(em -> true), expect);
    }
}