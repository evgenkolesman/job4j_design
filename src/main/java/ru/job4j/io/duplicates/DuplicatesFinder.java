package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* Поиск  дубликатов
 * Поиск дубликатов в файловой системе по заданным параметрам
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class DuplicatesFinder {
    public static void main(String[] args) throws IOException {
        if (args.length == 0) {
            throw new IllegalArgumentException("Root folder is null. Usage java -jar dir.jar ROOT_FOLDER.");
        }
        for (String arg : args) {
            Files.walkFileTree(Path.of(arg), new DuplicatesVisitor());
        }
    }
}
