package ru.job4j.solid.srp.ocp;

// третий пример, отсутвие гибкости условия,
// возможно измение высоты, например,
// соответсвенно нужно вставлять во всех случаях предикат

public class WrongOCP3 {
    private int h;

    public void main() {
        if (h < 100) {
            paratropersSit();
        } else {
            paratropersJump();
        }
    }

    private void paratropersJump() {
    }

    private void paratropersSit() {
    }
}
