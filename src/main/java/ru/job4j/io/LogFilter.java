package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class LogFilter {
    public static List<String> filter(String file) {
        List<Stream<String>> file1 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            file1.add(in.lines());
            //in.lines().forEach(System.out::println);
            Stream stream = file1.stream();
            //stream.filter(Objects.equals(file1.get(file1.size()-1), "404")).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace(); }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}
