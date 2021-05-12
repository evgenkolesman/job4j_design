package ru.job4j.serialization.json;

import java.util.Arrays;

/* JSON - демонстрация
 * Преобразование JSON в POJO. JsonObject
 * на основе класса EmployeeJSON
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class EmployeeJSON {
    private boolean sex;
    private int age;
    private Contact contact;
    private String[] statuses;

    public EmployeeJSON(boolean sex, int age, Contact contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return String.format("Employee{sex=%s, age=%d, contact=%s, statuses=%s}", sex, age, contact, Arrays.toString(statuses));
    }

    public static void main(String[] args) {
        final EmployeeJSON employee = new EmployeeJSON(false, 25,
                new Contact("8-8442-73-73-73"), new String[]{"Builder", "Slinger", "Free"});
        System.out.println(employee);
    }
}
