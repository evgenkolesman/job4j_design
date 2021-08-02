package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.store.Store;

import java.util.function.Predicate;
/*
 * Производство отчетов
 * класс реализация интерфейса Report
 * генераторы под задания:
 * отдел программистов потребовал ответы в виде html
 * Отдел бухгалтерии попросил изменить вид зарплаты
 * Отдел HR попросил выводить сотрудников в порядке убывания зарплаты и убрать поля даты найма и увольнения.
 *
 */

public class ReportHR implements Report{
    Store store;

    public ReportHR(Store store) {
        this.store = store;
    }

    @Override
    public String generateReport(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Salary;").append(System.lineSeparator());
        store.sort();
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}
