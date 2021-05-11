package ru.job4j.serialization.json;

import org.json.JSONObject;

/* Преобразование JSON в POJO.
 * Пример рекурсивного зацикливания.
 * Класс B для примера
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class B {
    private A a;

    public A getA() {
        return a;
    }

    public void setA(A a) {
        this.a = a;
    }

    public static void main(String[] args) {
        A a = new A();
        B b = new B();
        a.setB(b);
        b.setA(a);

        System.out.println(new JSONObject(b));
    }
}
