package ru.job4j.io;

import java.io.*;
import java.util.List;
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
        Search searchFile = new Search();
    }

    //считывание и записывание файлов в zip
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
    }

    //упаковка файла
    public static void main(String[] args) {
        new Zip().packSingleFile(
                new File("./projects/pom.xml"),
                new File("./chapter_005/pom.zip")
        );
    }
}
