package ru.job4j.generics;

public class RoleStore implements Store<Role> {
    private final Store<Role> store1 = new MemStore<>();

    /*public int indexOf(String id) {
        return store1.indexOf(id);
    }*/

    @Override
    public void add(Role model) {
        store1.add(model);
    }

    @Override
    public boolean replace(String id, Role model) {
        return store1.replace(id, model);
    }

    @Override
    public boolean delete(String id) {
        return store1.delete(id);
    }

    @Override
    public Role findById(String id) {
        return store1.findById(id);
    }

    /*public class User extends Base {
        /*private String name;
        private int age;
        private String buy;*/
        /*public User(String id, T model) {
            super(id);
        }
    }*/
}
