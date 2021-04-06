package ru.job4j.io;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.lang.System.lineSeparator;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> listFile = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            //String line = in.readLine();// до сюда процесс чтения
            String a = "404";
            listFile = in.lines().filter(((String s) -> s.contains(a))).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFile;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(new BufferedOutputStream(
                new FileOutputStream(file)))) {
            for (String s : log) {
                out.write(s);
                out.write(lineSeparator());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        save(log, "404.txt");
    }
}
