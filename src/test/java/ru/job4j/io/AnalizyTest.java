package ru.job4j.io;

import org.junit.Test;

public class AnalizyTest {

    @Test
    public void unavailableTest() {
        Analizy un = new Analizy();
        un.unavailable("Sourcefile.txt", "Targetfile.txt");
    }


}