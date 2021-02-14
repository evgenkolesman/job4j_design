package ru.job4j.generics;

public class UserStore implements Store<User> {
    private final Store<User> store = new MemStore<>();

    public int indexOf(String id) {
        return store.indexOf(id);
    }

    public void add(User model) {
        store.add(model);
    }

    public boolean replace(String id, User model) {
        return store.replace(id, model);
        //  надо разобраться как сделать перемещение
    }

    public boolean delete(String id) {
        return store.delete(id);
    }

    public User findById(String id) {
        return store.findById(id);
    }

}
// надо создать класс User

