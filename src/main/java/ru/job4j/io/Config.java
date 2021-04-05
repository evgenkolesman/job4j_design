package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class Config {
    private final String path;
    private final Map<String, String> values = new HashMap<>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader loader = new BufferedReader(new FileReader(this.path))) {
            loader.lines().filter(s -> !(s.isEmpty() || s.startsWith("#"))).filter(s -> s.contains("="))
                    .forEach(s -> values.put(s.substring(0, s.indexOf("=")), s.substring(s.indexOf("=") + 1)));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String value(String key) {
        if (values.containsKey(key)) {
            return values.get(key);
        } else {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }
}

