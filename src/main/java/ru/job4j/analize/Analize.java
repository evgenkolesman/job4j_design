package ru.job4j.analize;

import java.util.*;

/* Сначала пошел через простое написание тестов,
 под них стал выстраивать метод diff и классы, методы извлекающие
id и name считаю лишними, начал через
простой цикл, итераторы, а потом решил применить Map ,
так как на лицо классический вариант пар ключ - значение
 */

public class Analize {

    public Info diff(List<User> previous, List<User> current) {
        int deleted = 0;
        int changed = 0;
        int added;

        HashMap<Integer, String> allUsers = new HashMap<>();

        for (User index : current) {
            allUsers.put(index.id, index.name);
        }

        for (User index : previous) {
            if (!allUsers.containsKey(index.id)) {
                deleted++;
            } else if (!allUsers.get(index.id).equals(index.name)) {
                changed++;
            }
            allUsers.put(index.id, index.name);
        }

        int newSize = allUsers.size();
        added = newSize - previous.size();
        return new Info(added, changed, deleted);
    }

    public static class User {
        int id;
        String name;

        public User(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public static class Info {
        int added;
        int changed;
        int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }
}


