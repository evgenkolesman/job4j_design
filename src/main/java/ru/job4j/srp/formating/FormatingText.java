package ru.job4j.srp.formating;

import org.json.JSONObject;
import ru.job4j.srp.Employee;

/**
 * Форматирование текста  в формат Json,
 * и возможность записи в формат XML объекта класса Employee
 */
public class FormatingText implements Formatting {
    @Override
    public JSONObject toJson(String text) {
        JSONObject jsonText = new JSONObject(text);
        return jsonText;
    }

    @Override
    public String toXML(Employee employee) {
        return String.format("Employee{name=%s, hired=%d, fired=%s, salary=%s}", employee.getName(), employee.getHired(), employee.getFired(), employee.getSalary());
    }

    @Override
    public String toHTML(String text) {
        StringBuilder builder = new StringBuilder();
        boolean previousWasASpace = false;
        for (char c : text.toCharArray()) {
            if (c == ' ') {
                if (previousWasASpace) {
                    builder.append("&nbsp;");
                    previousWasASpace = false;
                    continue;
                }
                previousWasASpace = true;
            } else {
                previousWasASpace = false;
            }
            switch (c) {
                case '<':
                    builder.append("&lt;");
                    break;
                case '>':
                    builder.append("&gt;");
                    break;
                case '&':
                    builder.append("&amp;");
                    break;
                case '"':
                    builder.append("&quot;");
                    break;
                case '\n':
                    builder.append("<br>");
                    break;
                // We need Tab support here, because we print StackTraces as HTML
                case '\t':
                    builder.append("&nbsp; &nbsp; &nbsp;");
                    break;
                default:
                    if (c < 128) {
                        builder.append(c);
                    } else {
                        builder.append("&#").append((int) c).append(";");
                    }
            }
        }
        return builder.toString();
    }
}

