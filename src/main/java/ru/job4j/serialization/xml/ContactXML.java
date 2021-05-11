package ru.job4j.serialization.xml;

import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

/* Класс Contact
 * собирает и выводит определенный формат данных:  номер телефона
 * данный класс собран под возможность сериализации/десериализации основного класса EmployeeXML
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
@XmlElement(value = "contact")
public class ContactXML {
    @XmlAttribute
    private String phone;

    public ContactXML() {}
    public ContactXML(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Contact{phone='%s'}", phone);
    }
}
