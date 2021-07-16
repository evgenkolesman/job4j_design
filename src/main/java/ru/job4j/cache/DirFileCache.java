package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод который реализует абстрактный метод пишет данные из файла и тд
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class DirFileCache extends AbstractCache<String, String> {

    public DirFileCache(String cachingDir) {
    }

    @Override
    protected String load(String key) throws IOException {
        put(key, Files.readString(Path.of(key), Charset.forName("WINDOWS-1251")));
        return cache.get(key).get();
    }

    private String readFile(String path) {
        String a = "";
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            a = br.lines().toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return a;
    }
}
