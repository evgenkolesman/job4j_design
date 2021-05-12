package ru.job4j.serialization.json;

/* Класс Contact
 * собирает и выводит определенный формат данных:  номер телефона
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */


import com.sun.xml.txw2.annotation.XmlElement;

import javax.xml.bind.annotation.XmlAttribute;

@XmlElement(value = "contact")
public class ContactJSON {

    @XmlAttribute
    private String phone;

    public ContactJSON() {
    }

    public ContactJSON(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Contact{phone='%s'}", phone);
    }
}