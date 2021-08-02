package ru.job4j.solid.srp.formating;

import org.json.JSONObject;

/*
 * Класс реализация интерфейса
 * для преобразования теста в различные форматы
 * JSON -> FormateToJSON
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class FormatToJSON implements Formatting {
    String text;

    public FormatToJSON(String text) {
        this.text = text;
    }

    @Override
    public String format() {
        JSONObject jsonText = new JSONObject(text);
        return jsonText.toString();
    }

    @Override
    public String toString() {
        return String.format("TranslateToJSON{text = '%s'}", text);
    }
}
