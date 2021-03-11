package ru.job4j.collection;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class User {
    private String name;
    private int children;
    private Calendar birthday;

    public User(String name, int children, Calendar birthday) {
        name = this.name;
        children = this.children;
        birthday = this.birthday;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2020, Calendar.FEBRUARY, 2);
        User first = new User("Joe", 2, calendar);
        User second = new User("Joe", 2, calendar);
        Map<User, Object> map = new HashMap<>();
        Object element1 = 1111;
        Object element2 = 1;
        map.put(first, element1);
        map.put(second, element1);
        System.out.println("MAP = " + map);
        //System.out.println("User 1 = " + first + " User 2 = " + second);
        Calendar calendar1 = new GregorianCalendar(2018, Calendar.NOVEMBER, 3);
        Calendar calendar2 = new GregorianCalendar(2017, Calendar.OCTOBER, 10);
        User third = new User("Irwin ", 1, calendar1);
        User forth = new User("Lary ", 3, calendar1);
        Object element3 = 3;
        Object element4 = 4;
        map.put(first, element3);
        map.put(second, element4);
        System.out.println("MAP = " + map);
    }
}
