package ru.job4j.serialization.json;

/* Класс Contact
 * собирает и выводит определенный формат данных:  номер телефона
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class ContactJSON {
    private final String phone;

    public ContactJSON(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("Contact{phone='%s'}", phone);
    }
}