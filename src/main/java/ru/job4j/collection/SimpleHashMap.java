package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> {
    // надо посмотреть что именно надо убрать что оставить
    private int size = 0;
    private int capasity = 10;
    private int modCount = 0;
    private mapEntry<K, V>[] table = new mapEntry[capasity];


    public class mapEntry<K, V> {
        private K key;
        private V value;

        public mapEntry(K key, V value) {
            key = this.key;
            value = this.value;
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

    private void resize() {
        if (size == table.length) {
            table = Arrays.copyOf(table,
                    (table.length + 1) * 2);
        }
    }

    public boolean insert(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                table[i].setValue(value);
                return false;
            }
        }
        resize();
        table[size++] = new mapEntry<K,V>(key, value);
        //size++;
        return true;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (table[i] != null) {
                if (table[i].getKey().equals(key)) {
                    table[i].getValue();
                }
            }
        }
        return null;
    }

    public boolean delete(V key) {
        for (int i = 0; i < size; i++) {
            if (table[i].getKey().equals(key)) {
                table[i] = null;
                lessArr(i);
                return true;
            }
        }
        return false;
    }

    public void lessArr(int a) {
        //тут можно применить Arrays.copy но так надежнее
        System.arraycopy(table, a, table, a + 1, table.length - a - 1);
        table[table.length - 1] = null;
        size--;
        /*или по старому доброму циклу
        for (int i = a; i < size; i++) {
            table[i] = table[i + 1];
        }*/
    }

    public Iterator<K> iterator() {
        K[] itArray = (K[]) new Object[size - 1];
        for (int i = 0; i < size; i++) {
            itArray[i] = table[i].getKey();
        }

        return new Iterator<>() {
            int index = 0;
            private final int modCountExp = modCount;

            @Override
            public boolean hasNext() {
                return index < itArray.length
                        && modCount == modCountExp;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return itArray[index++];
            }
        };
    }

}

