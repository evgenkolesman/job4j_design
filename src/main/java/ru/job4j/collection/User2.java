package ru.job4j.collection;

import java.util.*;

public class User2 {
    private String name2;
    private int children2;
    private Calendar birthday2;

    public User2(String name2, int children2, Calendar birthday2) {
        this.name2 = name2;
        this.children2 = children2;
        this.birthday2 = birthday2;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2020, Calendar.FEBRUARY, 2);
        User2 first = new User2("Joe", 2, calendar);
        User2 second = new User2("Joe", 2, calendar);
        Map<User2, Object> map = new HashMap<>();
        Object element1 = 1;
        Object element2 = 2;
        //map.put(first, element1);
        //map.put(second, element2);
        //System.out.println("MAP = " + map);
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println("MAP = " + map);

    }

    //4 задание
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User2 user = (User2) o;
        return children2 == user.children2 && Objects.equals(name2, user.name2) && Objects.equals(birthday2, user.birthday2);
    }
}

