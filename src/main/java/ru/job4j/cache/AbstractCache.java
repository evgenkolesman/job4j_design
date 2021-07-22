package ru.job4j.cache;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/* Реализация кэша
 * Абстрактный метод реализация: ключ - адрес, значение - список данных файла
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public abstract class AbstractCache<K, V> {

    protected final Map<K, SoftReference<V>> cache = new HashMap<>();

    public void put(K key, V value) {

        SoftReference<V> valueMap = new SoftReference(value);
        cache.put(key, valueMap);
    }

    public V get(K key) {

        V value = cache.getOrDefault(key, new SoftReference<V>(null)).get();

        if (value == null) {
            value = load(key);
            put(key, value);
        }

        return value;
    }

    protected abstract V load(K key);
}
