package ru.job4j.gc;

/*
 * Демонстрация garbage collector
 * объект User с полями для демонстрации
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class User {
    private String name;
    private long id;
    private String speciality;

    public User(String name, long id, String speciality) {
        this.name = name;
        this.id = id;
        this. speciality = speciality;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSpeciality() {
        return speciality;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", speciality='" + speciality + '\'' +
                '}';
    }

    public void finalize() {
        System.out.printf("Removed %d %s %s%n", id, name, speciality);
    }
}
