package ru.job4j.srp.formating;

import org.json.JSONObject;

public class TranslateToJSON implements Formatting{
    String text;

    public TranslateToJSON (String text) {
        this.text = text;
    }

    @Override
    public String translation() {
        JSONObject jsonText = new JSONObject(text);
        return jsonText.toString();
    }

    @Override
    public String toString() {
        return String.format("TranslateToJSON{text = '%s'}", text);
    }
}
