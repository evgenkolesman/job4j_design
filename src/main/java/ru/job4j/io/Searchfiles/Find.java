package ru.job4j.io.searchfiles;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/*
 * Программа ищет данные в заданном каталоге и подкаталогах.
 * Имя файла может задаваться, целиком, по маске, по регулярному выражению(не обязательно).
 * Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/ -n=*.txt -t=mask -o=log.txt
 * Ключи
 * -d - директория, в которой начинать поиск.
 * -n - имя файла, маска, либо регулярное выражение.
 * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
 * -o - результат записать в файл.
 * Программа записывает результат в файл log.txt.
 * В программе должна быть валидация ключей и подсказка.
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class Find {
    private static final String FILETOWRITE = "log1.txt"; // из-за переменной не собирал в трэвисе
    
    public static void main(String[] args) {
        Path start = Paths.get("C:/");
        List<Path> pathList = new ArrayList<>(search(start, p -> p.toFile().getName().endsWith("txt")));
        try (BufferedWriter br = new BufferedWriter(new FileWriter(FILETOWRITE))) {
            for (Path a : pathList) {
                br.write(a.toString());
                br.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<Path> search(Path root, Predicate<Path> condition) {
        SearchFiles searcher = new SearchFiles(condition);
        try {
            Files.walkFileTree(root, searcher);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return searcher.getPaths();
    }

}
