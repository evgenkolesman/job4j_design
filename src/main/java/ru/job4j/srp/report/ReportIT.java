package ru.job4j.srp.report;

import ru.job4j.srp.Employee;
import ru.job4j.srp.formating.FormatToHTML;
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

public class ReportIT implements Report{
    private Store store;

    public ReportIT(Store store) {
        this.store = store;
    }

    @Override
    public String generateReport(Predicate<Employee> filter) {
        String result = generateReportFunc(filter);
        FormatToHTML formatingText = new FormatToHTML(result);
        return formatingText.format();
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
