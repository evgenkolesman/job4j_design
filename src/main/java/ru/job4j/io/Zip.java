package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/* Архивирование проекта
 * Утилита для архивации папки
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Zip {

    //метод должен запаковать файлы
    public void packFiles(List<File> source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            for (File file : source) {
                zip.putNextEntry(new ZipEntry(file.getPath()));
                try (BufferedInputStream out = new BufferedInputStream(
                        new FileInputStream(file))) {
                    zip.write(out.readAllBytes());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* считывание и записывание файлов в zip пример на одном файле
    public void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(
                new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }*/

    // метод поиска дубликатов
    public static List<File> searchFiles(Path path, String ex) {
        List<Path> newList = new ArrayList<>();
        try {
            newList = Search.search(path, a -> !a.toFile().getName().endsWith(ex));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return newList.stream().map(Path::toFile).collect(Collectors.toList());
    }

    //упаковка файла
    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        if (args.length != 3) {
            throw new IllegalArgumentException("Не верно записаны параметры, "
                    + "пример: -d=папка назначения -e= исключение, тип файлов "
                    + "-o=во что  преобразовываем .zip");
        }
        new Zip().packFiles(
                searchFiles(Paths.get(argsName.get("d")), argsName.get("e")),
                new File(argsName.get("o"))
        );
    }
}
