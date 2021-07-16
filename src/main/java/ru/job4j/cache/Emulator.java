package ru.job4j.cache;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        while (sc.next().equals("Y")) {
            System.out.println("Write cache directory: ");

            var resDirIn = sc.next();
            DirFileCache dirFileCache = new DirFileCache(resDirIn);
            System.out.println("Write directory for output: ");
            var resDirOut = sc.next();
            if (!resDirIn.isEmpty() || !dirFileCache.cache.isEmpty()) {
                writerFile(resDirOut, dirFileCache.load(resDirIn));
            }
            System.out.println("If you want to get in console cache write 'Y', else write 'N'");
            var answer = sc.next();
            if (answer.equals("Y")) {

                    System.out.println(Files.readString(Path.of(resDirIn)));
                    System.out.println("Do you want to continue and write cache from file? Y/N");

            } else {
                System.out.println("Hello! Do you want to write cache from file? Y/N");

            }
        }
    }

    private static void writerFile(String value, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(value))) {
                bw.write(Files.readString(Path.of(path)));
                //bw.write(System.lineSeparator());
            } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
