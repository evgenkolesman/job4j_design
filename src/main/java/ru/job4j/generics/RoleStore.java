package ru.job4j.generics;

import javax.management.relation.Role;

public class RoleStore implements Store<Role> {
    @Override
    public void add(Role model) {

    }

    @Override
    public boolean replace(String id, Role model) {
        return false;
    }

    @Override
    public boolean delete(String id) {
        return false;
    }

    @Override
    public Role findById(String id) {
        return null;
    }

    public class User extends Base {
        /*private String name;
        private int age;
        private String buy;*/
        public User(String id, T model) {
            super(id);
        }
    }
}
