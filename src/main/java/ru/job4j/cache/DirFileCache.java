package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.nio.file.Files;
import java.nio.file.Path;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод который реализует абстрактный метод пишет данные из файла и тд
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class DirFileCache extends AbstractCache<String, String> {

    private final String cachingDir;

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected String load(String key) {
        try {
            Path path = Path.of(cachingDir);
            cache.put(key, new SoftReference(Files.readString(path)));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cache.get(key).get();
    }
}
