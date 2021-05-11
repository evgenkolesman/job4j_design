package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* Преобразование JSON в POJO.
 * Задание на перевод Класса Person в JSON, в потом POJO
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

    private int getAge() {
        return age;
    }

    private boolean isSex() {
        return sex;
    }

    @Override
    public String toString() {
        return String.format("Person{sex=%s, age=%d, contact=%s, statuses=%s}", sex, age, contact, Arrays.toString(statuses));
    }

    public static void main(String[] args) {
        //JSONObject из json-строки строки
        JSONObject jsonContact = new JSONObject("{\"phone\":\"+7(924)111-111-11-11\"}");

        //JSONArray из ArrayList
        List<String> list = new ArrayList<>();
        list.add("Student");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        //JSONObject напрямую методом put
        final Person person = new Person(false, 30, new Contact("11-111"), new String[]{"Worker", "Married"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", person.isSex());
        jsonObject.put("age", person.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        //Выведем результат в консоль
        System.out.println(jsonObject.toString());

        //Преобразуем объект person в json-строку
        System.out.println(new JSONObject(person).toString());
    }
}

/*прошлое задание было реализовано с таким main
public static void main(String[] args) {
    final Person person = new Person(false, 33, new Contact("77-28-15"), new String[]{"Builder", "Married"});

        // Преобразуем объект person в json-строку.
        final Gson gson = new GsonBuilder().create();
        System.out.println(gson.toJson(person));

        // Модифицируем json-строку
        final String personJson =
                String.format("{\"sex\":false,\"age\":35,\"contact\":{\"phone\":\"+7(924)000-11-11\"},\"statuses\":[\"Student\",\"Free\"]}");
        final Person personMod = gson.fromJson(personJson, Person.class);
        System.out.println(personMod);
    }*/