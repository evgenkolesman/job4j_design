package ru.job4j.srp;

import java.util.function.Predicate;

import static org.apache.commons.lang3.StringEscapeUtils.escapeHtml4;

/*
 * Производство отчетов
 * класс реализация интерфейса Report
 * генераторы под задания:
 * отдел программистов потребовал ответы в виде html
 * Отдел бухгалтерии попросил изменить вид зарплаты
 * Отдел HR попросил выводить сотрудников в порядке убывания зарплаты и убрать поля даты найма и увольнения.
 *
 */
public class ReportEngine implements Report {
    private Store store;

    public ReportEngine(Store store) {
        this.store = store;
    }

    @Override
    public String generateIT(Predicate<Employee> filter) {
        return escapeHtml4(generateReport(filter));
    }

    @Override
    public String generateHR(Predicate<Employee> filter) {
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

    @Override
    public String generateBuh(Predicate<Employee> filter) {
        return generateReport(filter);
    }

    //генерируем отчет
    private String generateReport(Predicate<Employee> filter) {
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
