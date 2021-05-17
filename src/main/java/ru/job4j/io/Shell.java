package ru.job4j.io;

import java.util.*;

/* Симуляция терминала Linux
 * выполняем команду cd путем чтения и исполнения соответсвенных реакций
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class Shell {
    private List<String> list = new ArrayList<>();
    private final String root = "/user";

    public void cd(String path) {
        String[] array = path.split("/");
        for (String s : array) {
            if (s.equals("..")) {
                list.remove(s);
            } else if ((array.length > 2) && s.equals(array[1])) {
                list.clear();
                String[] path1 = path.split("//");
                String[] path2 = path1[0].split("//");
                list.add(path2[0]);
                break;
            } else {
                list.add(s);
            }
        }
    }

    public String pwd() {
        StringBuilder rsl = new StringBuilder();
        List<String> list1 = new ArrayList<>(list);
        for (String s : list1) {
            if (s.startsWith("/")) {
                rsl.append(s);
            } else {
            rsl.append("/").append(s);
            }
        }
        if (rsl.toString().equals("") || rsl.toString().equals(root)) {
            return "/";
        }
        if (rsl.toString().contains("root")) {
            return "/root";
        }

        return rsl.toString();
    }
}
