package ru.job4j.cache;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод DirFileCache - дочка AbstractCache
 *
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Emulator {

    public static void main(String[] args) throws IOException {
        System.out.println("Hello! Do you want to write cache from file? Y/N, else program will close");
        var sc = new Scanner(System.in);
        while (sc.next().equalsIgnoreCase("Y")) {
            System.out.println("Write cache directory: ");
            var resDirIn = sc.next();
            System.out.println("Write cache file for input: ");
            var resDirIn1 = sc.next();
            DirFileCache dirFileCache = new DirFileCache(resDirIn);
            System.out.println("Write path for output: ");
            var resDirOut = sc.next();
            if (!resDirIn1.isEmpty() || !dirFileCache.cache.isEmpty()) {
                dirFileCache.writerFile(resDirIn1, resDirOut);
            }
            else System.out.println("Wrong file or directory!");
            System.out.println("If you want to get in console cache write 'Y', else write 'N'");
            var answer = sc.next().toUpperCase();
            if (answer.equals("Y")) {
                System.out.println(Files.readString(Path.of(resDirIn, resDirIn1), Charset.forName("WINDOWS-1251")));
                System.out.println("Do you want to continue and write cache from file? Y/N");

            } else {
                System.out.println("Hello! Do you want to write cache from file? Y/N");
            }
        }
    }
}

