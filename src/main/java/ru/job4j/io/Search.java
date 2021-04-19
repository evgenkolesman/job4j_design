package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Search {

    public static void main(String[] args) {
        Path start = Paths.get(".");
        try {
            List<Path> arr = new ArrayList<>(search(start, p -> p.toFile().getName().endsWith(".txt")));
            List<String> arr1 = arr.stream().map(ar -> ar.getFileName().toString()).collect(Collectors.toList());
            for (String i : arr1) {
                System.out.println(i.substring(0, i.length() - 4) + " -- тип файла -> .txt");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(root, searcher);
        return searcher.getPaths();
    }
}
