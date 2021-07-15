package ru.job4j.cache;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* Реализация кэша
 * Абстрактный метод: AbstractCache
 * Метод который реализует абстрактный метод пишет данные из файла и тд
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class DirFileCache extends AbstractCache<String, List <String>> {

    private final String cachingDir;
    private List<String> list = new ArrayList<>();
    private Map<String, List<String>> map = new HashMap<>();

    public DirFileCache(String cachingDir) {
        this.cachingDir = cachingDir;
    }

    @Override
    protected List<String> load(String key) {
        map.put(key, readerFile(key));
        return map.get(key);
    }

    private List<String> readerFile(String value) {
        try (BufferedReader br = new BufferedReader(new FileReader(value))) {
            br.lines().forEach(list::add);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
