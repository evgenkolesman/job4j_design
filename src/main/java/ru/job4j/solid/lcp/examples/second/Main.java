package ru.job4j.solid.srp.lcp.examples.second;

public class Main {
    static void resize(Rectangle r, int newWidth, int newHeight) {
        r.setWidth(newWidth);
        r.setHeight(newHeight);
    }

    public static void main(String[] args) {
        Rectangle r = new Rectangle();
        Square s = new Square();
        resize(r, 2, 3);
        resize(s, 2, 3);
        System.out.println(r.getArea()); //2*3=6
        System.out.println(s.getArea()); //ошибка
    }
}
