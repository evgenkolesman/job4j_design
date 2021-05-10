package ru.job4j.serialization.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.Arrays;

/* Формат JSON
 * Перевод объекта с разными типами данных в
 * формат JSON и наоборот.
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Person {
    private final boolean sex;
    private final int age;
    private final Contact contact;
    private final String[] statuses;

    public Person(boolean sex, int age, Contact contact, String[] statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.statuses = statuses;
    }

    @Override
    public String toString() {
        return String.format("Person{sex=%s, age=%d, contact=%s, statuses=%s}", sex, age, contact, Arrays.toString(statuses));
    }

    public static void main(String[] args) {
    final Person person = new Person(false, 33, new Contact("77-28-15"), new String[]{"Builder", "Married"});

        /* Преобразуем объект person в json-строку. */
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        /* Модифицируем json-строку */
        final String personJson =
                String.format("{\"sex\":false,\"age\":35,\"contact\":{\"phone\":\"+7(924)000-11-11\"},\"statuses\":[\"Student\",\"Free\"]}");
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }
}
