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
import java.util.regex.Pattern;
import java.nio.file.AccessDeniedException;
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

public class Find extends AccessDeniedException {
    private static String fileToWrite; // из-за переменной не собирал в трэвисе

    public Find(String file, String other, String reason) {
        super(file, other, reason);
    }

    public static void main(String[] args) throws IOException {
        Args newarg = new Args(args);
        newarg.validateArgs();
        fileToWrite = args[7];
        Path start = Paths.get(args[1]);
        System.out.println(getString(newarg.getPattern()));
        System.out.println(newarg.getTypeSearch());
        //- контролировал метод отсева по характеристикам он здесь не нужен только как доп контроль
        List<Path> pathList = new ArrayList<>(search(start, getCondition(newarg)));
        writeLog(pathList);
    }

    //метод преобразования маски в расширение             было - ВМЕСТО ПРЕДИКАТА, проверка по характеристикам для поиска
    private static String getString(String args) {
        String exp;
        String[] expArr = args.split("\\*");
        exp = expArr[1];
        // финализируем результат и по нему ищем что нам надо обходить данные
        return exp;
    }

    private static Predicate<Path> getCondition(Args args) {
        String type = args.getTypeSearch();
        Predicate<Path> result = p -> true;
        switch (type) {
            // по маске оставляем .txt c помощью getString
            case "mask":
                result = p -> p.toFile().getName().endsWith((getString(args.getPattern())));
                break;
            // по имени
            case "name":
                result = p -> p.toFile().getName().equals(args.getPattern());
                break;
            //по регулярке
            case "regex":
                result = p -> p.toFile().getName().matches(args.getPattern());
                break;
            default:
                break;
        }
        return result;
    }

    // полностью забрал метод так как лучше ничего не придумал
    private static class RegexSearchCondition implements Predicate<Path> {

        private final Pattern pattern;

        public RegexSearchCondition(String name) {
            this.pattern = Pattern.compile(name);
        }

        @Override
        public boolean test(Path path) {
            return pattern.matcher(path.toFile().getName()).matches();
        }
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