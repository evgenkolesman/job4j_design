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
        System.out.println("Hello! Do you want to write cache from file? Y/N");
        var sc = new Scanner(System.in);
        var ans = sc.next();
        System.out.println("Write cache directory: ");
        var resDirIn = sc.next();
        DirFileCache dirFileCache = new DirFileCache(resDirIn);
        while (ans.equalsIgnoreCase("Y")) {
            System.out.println("Write file for input: ");
            var resDirIn1 = sc.next();
            System.out.println("Write path for output: ");
            var resDirOut = sc.next();
            if (!dirFileCache.cache.isEmpty() || !resDirIn.isEmpty()) {
                dirFileCache.writerFile(resDirIn1, resDirOut);
            } else {
                System.out.println("Wrong file!");
            }
            System.out.println("If you want to get in console and write file, print 'Y', else ptint 'N'");
            var answer = sc.next().toUpperCase();
            if (answer.equals("Y")) {
                System.out.println(Files.readString(Path.of(resDirIn, resDirIn1), Charset.forName("WINDOWS-1251")));
                System.out.println("Do you want to continue and write file? Y/N");
                if (sc.next().equalsIgnoreCase("y")) {
                    continue;
                } else {
                    break;
                }
            } else {
                System.out.println("Hello! Do you want to write write file? Y/N");
            }
        }
    }
}

