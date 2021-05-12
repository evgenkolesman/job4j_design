package ru.job4j.serialization.json;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/* Преобразование JSON в строку
 * Преобразование JSON в строку. JsonObject
 * на основе класса EmployeeJSON И EmployeeJSON
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class EmployeeJSONtoString {
    public static void main(String[] args) {
        // JSONObject из json-строки
        JSONObject jsonContact = new JSONObject("{\"phone\":\"8-8442-73-73-73\"}");

        // JSONArray из ArrayList
        List<String> list = new ArrayList<>();
        list.add("Builder");
        list.add("Slinger");
        list.add("Free");
        JSONArray jsonStatuses = new JSONArray(list);

        // JSONObject напрямую методом put
        final EmployeeJSON employee = new EmployeeJSON(false, 25,
                new ContactJSON("8-8442-73-73-73"), new String[]{"Builder", "Slinger", "Free"});
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("sex", employee.isSex());
        jsonObject.put("age", employee.getAge());
        jsonObject.put("contact", jsonContact);
        jsonObject.put("statuses", jsonStatuses);

        // Преобразуем объект jsonObject - копия дынных с employee в json-строку
        System.out.println(jsonObject.toString());

        //Преобразуем объект person в json-строку  - так не получается,
        // преобразовывает только 2 значения объекта типы int и String, а объекты не видит
        System.out.println(new JSONObject(employee).toString());


    }
}
