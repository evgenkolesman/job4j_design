package ru.job4j.io;

import java.util.*;

/* Именованные аргументы
 * Проверка аргумента по кодировке UTF-8 и занимаемой памяти 512
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class ArgsName {

    final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    // пробовал через List почему то не получилось, пока...
    public void parse(String[] args) {
        for (String arg : args) {
            String[] arg1 = arg.replaceFirst("-", "").split("=");
            if (arg1.length != 2) {
                throw new IllegalArgumentException("Не верно записаны параметры, пример: значение1=значение2");
            }
            values.put(arg1[0], arg1[1]);
        }
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
        ArgsName jvm = ArgsName.of(new String[]{"-Xmx=512", "-encoding=UTF-8"});
        System.out.println(jvm.get("Xmx"));

        ArgsName zip = ArgsName.of(new String[]{"-out=project.zip", "-encoding=UTF-8"});
        System.out.println(zip.get("out"));
    }
}
