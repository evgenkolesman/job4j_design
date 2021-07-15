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
        return (V) cache.get(key);
    }

    protected abstract V load(K key);
}
