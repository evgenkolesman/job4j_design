package ru.job4j.srp.formating;

import org.json.JSONObject;
import ru.job4j.srp.Employee;

public interface Formatting {

    public JSONObject toJson(String text);

    public String toXML(Employee employee);

    public String toHTML(String text);
}
