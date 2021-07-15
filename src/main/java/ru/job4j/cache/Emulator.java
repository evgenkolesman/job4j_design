package ru.job4j.cache;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод DirFileCache - дочка AbstractCache
 *
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Emulator {

    private String cacheDir; // возможно вместо сканнера просто заменить на cacheDir
    private static List<String> list = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("Hello! Do you want to write cache from file? Y/N");
        var sc = new Scanner(System.in);

        while (sc.next().equals("Y")) {
            System.out.println("Write cache directory: ");

            var resDirIn = sc.next();
            DirFileCache dirFileCache = new DirFileCache(resDirIn);
            System.out.println("Write directory for output: ");
            var resDirOut = sc.next();
            if(!resDirIn.isEmpty() || !dirFileCache.cache.isEmpty())
            writerFile(resDirOut, dirFileCache.load(resDirIn));
            System.out.println("If you want to get in console cache write 'Y', else write 'N'");
            var answer = sc.next();
            if (answer.equals("Y")) {
                for (String list2 : dirFileCache.load(resDirIn)) {
                    System.out.println(list2);
                    System.out.println("Do you want to continue and write cache from file? Y/N");
                }
            } else {
                System.out.println("Hello! Do you want to write cache from file? Y/N");

            }
        }
    }

    private static void writerFile(String value, List<String> listMap) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(value))) {
            for (String list1 : listMap) {
                bw.write(list1);
                bw.write(System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
