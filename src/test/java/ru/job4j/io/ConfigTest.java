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

    @Test
    public void whenAppPropertiesTest() {
        String path = "app.properties";
        Config config = new Config(path);
        config.load();
        assertThatApp(config);
    }

    // проверка ctrl+alt+m - вынос одинаковых методов в один
    private void assertThatApp(Config config) {
        assertThat(config.value("hibernate.dialect"), is("org.hibernate.dialect.PostgreSQLDialect"));
        assertThat(config.value("hibernate.connection.url"), is("jdbc:postgresql://127.0.0.1:5432/trackstudio"));
        assertThat(config.value("hibernate.connection.driver_class"), is("org.postgresql.Driver"));
        assertThat(config.value("hibernate.connection.username"), is("postgres"));
        assertThat(config.value("hibernate.connection.password"), is("password"));
    }


}