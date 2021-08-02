package ru.job4j.solid.srp.report;

import ru.job4j.solid.srp.Employee;
import ru.job4j.solid.srp.store.Store;

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

public class ReportBUH implements Report {
    private Store store;

    public ReportBUH(Store store) {
        this.store = store;
    }

    @Override
    public String generateReport(Predicate<Employee> filter) {
        return generateReportFunc(filter);
    }

    //генерируем отчет
    private String generateReportFunc(Predicate<Employee> filter) {
        StringBuilder text = new StringBuilder();
        text.append("Name; Hired; Fired; Salary;" + System.lineSeparator());
        for (Employee employee : store.findBy(filter)) {
            text.append(employee.getName()).append(";")
                    .append(employee.getHired()).append(";")
                    .append(employee.getFired()).append(";")
                    .append(employee.getSalary()).append(";")
                    .append(System.lineSeparator());
        }
        return text.toString();
    }
}

