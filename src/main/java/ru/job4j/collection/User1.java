package ru.job4j.collection;

import java.util.*;

public class User1 {
    private String name1;
    private int children1;
    private Calendar birthday1;

    public User1(String name1, int children1, Calendar birthday1) {
        this.name1 = name1;
        this.children1 = children1;
        this.birthday1 = birthday1;
    }

    public static void main(String[] args) {
        Calendar calendar = new GregorianCalendar(2020, Calendar.FEBRUARY, 2);
        User1 first = new User1("Joe", 2, calendar);
        User1 second = new User1("Joe", 2, calendar);
        Map<User1, Object> map = new HashMap<>();
        Object element1 = 1;
        Object element2 = 2;
        map.put(first, element1);
        map.put(second, element2);
        //System.out.println("MAP = " + map);
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println("MAP = " + map);

    }

    //3 задание
    @Override
    public int hashCode() {
        return Objects.hash(name1, children1, birthday1);
    }
}


