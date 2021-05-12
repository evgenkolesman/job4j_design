package ru.job4j.serialization.json;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Arrays;

/* JSON - демонстрация
 * Преобразование JSON в POJO. JsonObject
 * на основе класса EmployeeJSON
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmployeeJSON {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    private ContactJSON contact;
    private String[] statuses;

    public EmployeeJSON() {}

    public EmployeeJSON(boolean sex, int age, ContactJSON contact, String[] statuses) {
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
                new ContactJSON("8-8442-73-73-73"), new String[]{"Builder", "Slinger", "Free"});
        System.out.println(employee);
    }
}
