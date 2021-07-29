package ru.job4j.ocp;

// второй пример, измение условий должно быть гибко
// принцип OCP
public class WrongOCP2 {
    private int i;

    public void main() {
        if (i == 0) {
            System.out.println("Stop");
        } else {
            System.out.println("We are moving");
        }
    }
}

