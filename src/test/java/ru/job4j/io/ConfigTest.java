package ru.job4j.io;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "Configure.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name "),is(" Evgen Koles"));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenPairComment() {
        String path = "Configure.txt";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("first comment "),is(" Evgen Koles"));
    }
}