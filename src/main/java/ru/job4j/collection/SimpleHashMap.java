package ru.job4j.collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.util.Objects.hash;

public class SimpleHashMap<K, V> {
    // надо посмотреть что именно надо убрать что оставить
    private int size = 0;
    private final int capasity = 16;
    private int modCount = 0;
    private mapEntry<K, V>[] table = new mapEntry[capasity];


    //private int index = 0;

    //private int [] myHash = new int[capasity];

    public class mapEntry<K, V> {
        private K key;
        private V value;
        private int hash;

        public mapEntry(int hash, K key, V value) {
            key = this.key;
            value = this.value;
            hash = this.hash;
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

        int hash(int h) {
            h ^= (h >>> 20) ^ (h >>> 12);
            return h ^ (h >>> 7) ^ (h >>> 4);
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
        int result = hash(table[index]);
        result = 31 * result + Arrays.hashCode(table);
        //result = 31 * result + Arrays.hashCode(table.hash(index));
        //myHash[index] = result;
        index++;
        return result;
    }

    private void resize() {
        if (size == table.length) {
            table = Arrays.copyOf(table,
                    (table.length + 1) * 2);
        }
    }

    public boolean insert(K key, V value) {
        int index = indexFor(key.hashCode(), table.length);
        Objects.checkIndex(index, table.length);
        mapEntry<K, V> newValue = new mapEntry<K, V>(hash(key.hashCode()), key, value);
        int a = newValue.hashCode();
        if (newValue.hashCode() == hash(key.hashCode())) {
            table[index].setValue(value);
            return false;
        }

        resize();
        //mapEntry <K,V> newValue = new mapEntry<K,V>(key, value);
        table[size++] = newValue;
        //size++;
        modCount++;
        index++;
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

    //допилить delete и get
    public boolean delete(K key) {
        K key1 = table[indexFor(key.hashCode(), table.length)].getKey();
        if (key.equals(key1)) {
            table[indexFor(key.hashCode(), table.length)] = null;
            lessArr(indexFor(key.hashCode(), table.length));
            modCount++;
            return true;
        } else {
            return false;
        }

    }


    public int indexFor(int h, int length) {
        return h & (length - 1);
    }


    public void lessArr(int a) {
        //тут можно применить Arrays.copy но так надежнее
        System.arraycopy(table, a, table, a + 1, table.length - a - 1);
        table[table.length - 1] = null;
        size--;
        //или по старому доброму циклу
        //for (int i = a; i < size; i++) {
        //   table[i] = table[i + 1];
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
                return index < size
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














