package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleHashMap<K, V> {
    // надо посмотреть что именно надо убрать что оставить
    private int size = 0;
    private final int capasity = 2;
    //capasity должно быть 16, но поставил 2 что бы тестировать метод resize
    private int modCount = 0;
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
        if (table.length <= size * 0.75) {
            MapEntry<K, V>[] newTable = new MapEntry[table.length * 2];
            transfer(newTable);
            table = newTable;
        }
    }

    public void transfer(MapEntry<K, V>[] newTable) {
        newTable = new MapEntry[table.length * 2];
        for (int i = 0; i < table.length; i++) {
            int hash = table[i].getKey() == null ? 0 : hash(table[i].getKey().hashCode());
            newTable[indexFor(hash, table.length)] = table[i];
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
        if (key.equals(key1)) {
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
                return index < size && modCount == modCountExp;

                /*index < table.length && table[index].getKey() == null ? false : true
                        && table[index] == null ? false : true;*/
                //&& modCount == modCountExp;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                while (table[index] == null) {
                    index++;
                    if (table[index] != null) {
                        return table[index].getKey();
                    }
                }
                return table[index++].getKey();
                //return iterator().next();
            }
        };
    }
}





    /*public boolean insert(K key, V value) {
        //1 проверка на null ключа опустим пока
        if (key == null || value == null) {
            return false;
        }
        //2 генерация хэш для ключа
       // int index = 0;

        int hashKey = hash(key.hashCode());

        //3  С помощью метода indexFor(hash, tableLength),
        // определяется позиция в массиве, куда будет помещен элемент.
        int index = indexFor(hashKey, table.length);
        mapEntry<K, V> e = new mapEntry<>(hashKey, key, value);
        //4 Теперь, зная индекс в массиве, мы получаем список (цепочку) элементов, привязанных к этой ячейке.
        // Хэш и ключ нового элемента поочередно сравниваются с хэшами и ключами элементов из списка и,
        // при совпадении этих параметров, значение элемента перезаписывается.

        if (hashKey== e.key.hashCode() && (e.key == key || key.equals(e.key)))  {
            return false;
        }
        //Если же предыдущий шаг не выявил совпадений,
        // будет вызван метод addEntry(hash, key, value, index) для добавления нового элемента.
        resize();

        addEntry(hashKey, e.key, e.value, index);
        //index++;
        modCount++;
        return true;
    }

    public void addEntry(int hash, K key, V value, int index) {
        table[index] = new mapEntry<K, V>(hash, key, value);
        size++;
    }

    public static int indexFor(int h, int length) {
        return h & (length - 1);
    }

    private void resize() {
        if (size == table.length) {
            table = Arrays.copyOf(table,
                    (table.length + 1) * 2);
        }
    }

    public boolean delete(K key) {
        int index = indexFor(hash(key), table.length);
        V val1 = table[index].getValue();
        if (table[index].getKey().equals(key)) {
            //table[index] = null;
            lessArr(index);
            size--;
            modCount++;
            return true;
        }

        return false;
    }

    public void lessArr(int a) {
        //тут можно применить Arrays.copy но так надежнее
        System.arraycopy(table, a, table, a + 1, table.length - a - 1);
        //table[table.length - 1] = null;
        size--;

    }
}*/














