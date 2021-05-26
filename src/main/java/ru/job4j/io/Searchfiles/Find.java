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
 * Программа должна собираться в jar и запускаться через java -jar find.jar -d=c:/Games -n=*.txt -t= -o=log.txt
 * Ключи
 * -d - директория, в которой начинать поиск.
 * -n - имя файла, маска, либо регулярное выражение.
 * -t - тип поиска: mask искать по маске, name по полному совпадение имени, regex по регулярному выражению.
 * -o - результат записать в файл.
 * Программа записывает результат в файл log1.txt.
 * В программе должна быть валидация ключей и подсказка.
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class Find {
    private static String fileToWrite; // из-за переменной не собирал в трэвисе

    public static void main(String[] args) {
        Args newarg = new Args(args);
        newarg.validateArgs();
        fileToWrite = args[7];
        Path start = Paths.get(args[1]);

        final String exp1 = getString(args);
        //System.out.println(exp); - контролировал метод отсева по характеристикам он здесь не нужен только как доп контроль
        List<Path> pathList = new ArrayList<>(search(start, p -> p.toFile().getName().endsWith(exp1)));
        writeLog(pathList);
    }
    //ВМЕСТО ПРЕДИКАТА, проверка по характеристикам для поиска
    private static String getString(String[] args) {
        String exp = "";
        if (args[5].equals("mask")) {
            String[] expArr = args[3].split("\\*");
            exp = expArr[1];
        }
        if (args[5].equals("name")) {
            exp = args[3];
        }
        // финализируем результат и по нему ищем что нам надо обходя данные
        return exp;
    }

    private static void writeLog(List<Path> pathList) {
        try (BufferedWriter br = new BufferedWriter(new FileWriter(fileToWrite))) {
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