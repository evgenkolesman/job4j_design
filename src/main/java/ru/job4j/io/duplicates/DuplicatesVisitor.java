package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

/* Поиск  дубликатов
 * Поиск дубликатов в файловой системе по заданным параметрам
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {
    private final Set<FileProperty> fileProp = new HashSet<>();

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(file.toFile().length(), file.getFileName().toString());
        if (!(fileProp.add(fileProperty))) {
            System.out.println(file.toAbsolutePath());
        } else {
            fileProp.add(fileProperty);
        }
        return super.visitFile(file, attrs);
    }
}