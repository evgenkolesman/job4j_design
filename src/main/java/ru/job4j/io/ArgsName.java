package ru.job4j.io;

import java.lang.instrument.Instrumentation;
import java.util.*;

public class ArgsName {
    private static Instrumentation instrumentation;

    final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if(!values.containsKey(key)) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    public void parse(String[] args) {
        for (String arg : args) {
            String[] arg1 = arg.replaceFirst("-", "").split("=");
            //arg1.add(arg.replaceFirst("-", "").split("="));
            if (arg1.length != 2) {
                throw new IllegalArgumentException();
            }
            values.put(arg1[0], arg1[1]);
        }
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
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
