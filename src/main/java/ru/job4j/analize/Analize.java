package ru.job4j.analize;

import java.util.*;

/*Сначала пошел через простое написание тестов, под них стал выстраивать метод diff и классы, методы извлекающие
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





    /*public Info diff(List<User> previous, List<User> current) {
        int added1 = 0;
        int change = 0;
        int del = previous.size() - current.size() + added1;
        Info stat = new Info(del, change, added1);
        Iterator<User> iterCur = current.iterator();
        Iterator<User> iterPrev = previous.iterator();

        if (previous.size() >= current.size()) {

            for (int i = 0; i < current.size(); i++) {
                if(iterCur.hasNext()) {
                    User nextCurr = iterCur.next();
                    if (nextCurr.id == previous.get(i).id) {
                        if (!Objects.equals(current.get(i).name, previous.get(i).name)) {
                            added1++;
                        }
                    } else {
                        if (!Objects.equals(current.get(i).name, iterPrev.next().name)) {
                            change++;
                        }
                    }

                }
            }
        } else {

            User nextPrev = iterPrev.next();
            for (int z = 0; z < previous.size(); z++) {
                if (iterPrev.hasNext()) {
                    if (nextPrev.id != current.get(z).id) {
                        added1++;
                    } else {
                        while (!Objects.equals(iterCur.next().name, iterPrev.next().name)) {
                            change++;
                        }
                    }
                }
            }
        }

        return stat;
    }*/


/*List<User> previous;
    List<User> current;*/

    /*public Info diff(List<User> previous, List<User> current) {
        int added1 = 0;
        int changed1 = 0;
        int deleted1 = 0;
        Info stat = new Info(added1, changed1, deleted1);
        HashMap<Integer, String> prev = new HashMap<Integer, String>();
        HashMap<Integer, String> curr = new HashMap<Integer, String>();
        for(int i =0; i < previous.size(); i++){
        prev.put(previous.get(i).id, previous.get(i).name);
        }
        for(int z =0; z < current.size(); z++){
            curr.put(current.get(z).id, current.get(z).name);
        }
        if (previous.size() >= current.size()) {
            Iterator<Integer> iterCur = curr.keySet().iterator();
            while (iterCur.hasNext()) {
                for (int a = 0; a < current.size(); a++) {
                    if (iterCur.next() != previous.get(a).id) {
                        added1++;
                    }
                    else {
                            if (!Objects.equals(current.get(iterCur.next()).name, previous.get(a).name)) {
                              changed1++;
                            }
                    }
                }
                deleted1 = previous.size() - curr.size() + added1;
            }
        }

      return stat;
    }*/




/*public Info diff(List<User> previous, List<User> current) {
        int added1 = 0;
        int change = 0;
        int del;

        Iterator<User> iterCur = current.iterator();
        Iterator<User> iterPrev = previous.iterator();

        if (previous.size() >= current.size()) {
            for (int i = 0; i < current.size(); i++) {
                if (current.get(i).id == previous.get(i).id) {
                    if (!current.get(i).name.equals(previous.get(i).name)) {
                        added1++;
                    }
                } else {
                    if (!Objects.equals(current.get(i).name, iterPrev.next().name)) {
                        change++;
                    }
                }


            }
        } else {
            for (int z = 0; z < previous.size(); z++) {
                if (previous.get(z).id != current.get(z).id) {
                    added1++;
                } else {
                    while (!Objects.equals(iterCur.next().name, iterPrev.next().name)) {
                        change++;
                    }
                }
            }
        }
        del = previous.size() - current.size() + added1;
        return new Info(del, change, added1);
    }*/
