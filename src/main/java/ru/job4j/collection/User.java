package ru.job4j.collection;

import java.util.*;

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
        Object element1 = 1;
        Object element2 = 2;
        map.put(first, element1);
        map.put(second, element2);
        //System.out.println("MAP = " + map);
        map.put(first, new Object());
        map.put(second, new Object());
        System.out.println("MAP = " + map);

    }

    //это для 3 и 4 заданий
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children && Objects.equals(name, user.name) && Objects.equals(birthday, user.birthday);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, children, birthday);
    }
}

