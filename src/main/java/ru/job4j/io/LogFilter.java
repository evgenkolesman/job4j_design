package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> listFile = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            String line = in.readLine();// до сюда процесс чтения
            String a = "404";
            listFile = in.lines().filter(((String s) -> s.contains(a) /*&& s.indexOf(a) == s.length()-4)*/)).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listFile;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
        System.lineSeparator();
    }
}
