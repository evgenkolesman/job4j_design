package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/* поиск в файловой системе
 *Поиск в файловой системе по заданным параметрам
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class Search {

    public static void main(String[] args) {
        if (args.length != 2) {
            throw new IllegalArgumentException("Не верно задан аргумент : Root папка равна null. Надо так:  java -jar Search.jar ROOT_FOLDER");
        }
        Path start = Paths.get(args[0]);
        try {
            List<Path> arr = new ArrayList<>(search(start, p -> p.toFile().getName().endsWith(args[1])));
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
