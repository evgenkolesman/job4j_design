package ru.job4j.ocp;
// первый пример, измение условий должно быть гибко
// принцип OCP
public class WrongOCP1 {

    private String a;

    public void main() {
        if (a.equals("y")) {
            sendmessage();
        } else {
            exit();
        }
    }

    private void exit() {
    }

    private void sendmessage() {
    }
}

