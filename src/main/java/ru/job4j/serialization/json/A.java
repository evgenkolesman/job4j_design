package ru.job4j.serialization.json;

import org.json.JSONPropertyIgnore;

/* Преобразование JSON в POJO.
 * Пример рекурсивного зацикливания.
 * Класс A для примера
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class A {
    private B b;

    @JSONPropertyIgnore
    public B getB() {
        return b;
    }

    public void setB(B b) {
        this.b = b;
    }

    public String getHello() {
        return "Hello";
    }
}
