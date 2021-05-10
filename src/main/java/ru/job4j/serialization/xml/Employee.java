package ru.job4j.serialization.xml;

import java.util.Arrays;

/* XML - демонстрация
 * метод необходим для выполнения задания по иллюстрации xml файла
 * он собирает тип Employee: булево значение, числовое, объект типа Contact, массив строк
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Employee {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Employee(boolean sex, int age, Contact contact, String[] statuses) {
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
        final Employee employee = new Employee(false, 25,
                new Contact("8-8442-73-73-73"), new String[] {"Builder", "Slinger", "Free"});
        System.out.println(employee);
    }
}
