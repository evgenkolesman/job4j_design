package ru.job4j.cache;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод который реализует абстрактный метод пишет данные из файла и тд
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class DirFileCache extends AbstractCache<String, String> {

    String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

   @Override
    protected String load(String key) {
        return cache.get(key).get();
    }

    protected void writerFile(String path1, String path2) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path2))) {
            bw.write(Files.readString(Path.of(cachingDir, path1)));
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
