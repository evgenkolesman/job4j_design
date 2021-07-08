package ru.job4j.gc;

/*
 * Демонстрация garbage collector
 * пустой объект для подсчета объема памяти выделяемого под объект
 *  без полей
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class UserFree {
    public void finalize() {
        System.out.println("Removed UserFree");
    }
}
