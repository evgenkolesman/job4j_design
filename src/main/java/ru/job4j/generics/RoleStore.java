package ru.job4j.generics;

public class RoleStore<T extends Base> {
    public class User extends Base {
        /*private String name;
        private int age;
        private String buy;*/
        public User(String id) {
            super(id);
        }
    }
}
