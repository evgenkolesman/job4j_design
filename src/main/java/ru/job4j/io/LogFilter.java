/*package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

import static jdk.internal.org.jline.utils.InfoCmp.Capability.lines;

public class LogFilter {
    public static List<String> filter(String file) {
        List<Stream<String>> file1 = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
            file1.add(in.lines());
            //in.lines().forEach(System.out::println);
            Stream stream = file1.stream();
            //int a = file1.size() - 1;
            for (int index = 0; index < file1.size(); index++) {
            if(Object.equals(file1.get(index), "404")){

            }
            }
        } catch (Exception e) {
            e.printStackTrace(); }
        return null;
    }

    public static void main(String[] args) {
        List<String> log = filter("log.txt");
        System.out.println(log);
    }
}*/
