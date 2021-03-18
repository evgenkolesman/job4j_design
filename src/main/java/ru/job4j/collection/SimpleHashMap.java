package ru.job4j.collection;

import java.util.*;

public class SimpleHashMap<K, V> {
    // надо посмотреть что именно надо убрать что оставить
    private int size = 0;
    private int capasity = 16;
    //capasity должно быть 16, но поставил 2 что бы тестировать метод resize
    private int modCount = 0;
    private final double LOAD_FACTOR = 0.75;
    private MapEntry<K, V>[] table = new MapEntry[capasity];


    public class MapEntry<K, V> {
        private K key;
        private V value;
        private int hash;

        public MapEntry(int hash, K key, V value) {
            this.key = key;
            this.value = value;
            this.hash = hash;
        }


        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleHashMap<?, ?> that = (SimpleHashMap<?, ?>) o;
        return Arrays.equals(table, that.table);
    }

    @Override
    public int hashCode() {
        int index = 0;
        int result = hash(table[index].getKey().hashCode());
        result = 31 * result + Arrays.hashCode(table);
        //result = 31 * result + Arrays.hashCode(table.hash(index));
        //myHash[index] = result;
        index++;
        return result;
    }

    public int hash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    public int indexFor(int h, int length) {
        return h & (length - 1);
    }

    public void resize(int size) {
        if (table.length <= size * LOAD_FACTOR) {
            MapEntry<K, V>[] newTable = new MapEntry[table.length * 2];
            transfer(newTable);
            table = newTable;
        }
    }

    public void transfer(MapEntry<K, V>[] newTable) {
        newTable = new MapEntry[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            if (!Objects.equals(table[i].getKey(), null)) {
                int hash = table[i].getKey() == null ? 0 : hash(table[i].getKey().hashCode());
                newTable[indexFor(hash, table.length)] = table[i];
            }
        }
    }


    public boolean insert(K key, V value) {
        int hash = key == null ? 0 : hash(key.hashCode());
        int index = indexFor(hash, table.length);
        if (table[index] == null) {
            table[index] = new MapEntry<>(hash, key, value);
            modCount++;
            size++;
            resize(size);
            return true;
        }
        return false;
    }

    public V get(K key) {
        int hash = key == null ? 0 : hash(key.hashCode());
        int index = indexFor(hash, table.length);
        if (table[index] != null && table[index].getKey().equals(key)) {
            return table[index].getValue();
        }
        return null;
    }

    public boolean delete(K key) {
        K key1 = table[indexFor(key.hashCode(), table.length)].getKey();
        if (Objects.equals(key, key1)) {
            table[indexFor(key.hashCode(), table.length)] = null;
            modCount++;
            return true;
        } else {
            return false;
        }

    }

    public Iterator<K> iterator() {

        return new Iterator<>() {
            int index = 0;
            private final int modCountExp = modCount;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (modCount != modCountExp) {
                    throw new ConcurrentModificationException();
                }
                K a = null;
                for (int i = 0; i < table.length; i++) {
                    if (table[i] == null) {
                        index++;
                    } else
                        a = table[index++].getKey();
                }
                return a;
            }
                /*if (table[index] == null) {
                    index++;
                    return table[index].getKey();
                }*/


        };
    }
}

















