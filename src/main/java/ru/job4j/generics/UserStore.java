package ru.job4j.generics;

public class UserStore implements Store<RoleStore.User> {
    private final Store<RoleStore.User> store = new MemStore<>();

    public void add(RoleStore.User model) {
        store.add(model);
    }

    public boolean replace(String id, RoleStore.User model) {
        return store.replace(id, model);
        //  надо разобраться как сделать перемещение
    }

    public boolean delete(String id) {
        return store.delete(id);
    }

    public RoleStore.User findById(String id) {
        return store.findById(id);
    }

}
// надо создать класс User

