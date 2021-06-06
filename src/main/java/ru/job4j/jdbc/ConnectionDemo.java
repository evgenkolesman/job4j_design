package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*Настройка, взаимодействие с JDBC, SQL
 * Программа считывает строки из C:\projects\job4j_design\app.properties,
 * далее выделяем необходимые нам
 * данные url, login, password
 * и по ним  заходим  базу данных idea_db
 * необходиом добавить настройки в Travis:
 * # Start PostgreSQL
services:
  - postgresql

# Create a database
before_script:
  - psql -c 'create database travis_ci_test;' -U postgres
  * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
  * @version 1.0
 */
public class ConnectionDemo {
    private static final String FILE = "app.properties";
    private static String url;
    private static String login;
    private static String password;
    private static List<String> listadd = new ArrayList<>();
    private static final Properties PRS = new Properties();

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        Class.forName("org.postgresql.Driver");
        //не работает способ ухождения от  абсолютного пути не пойму почему..
        ConnectionDemo settings = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try (InputStream loadPath = loader.getResourceAsStream(FILE)) {
            PRS.load(loadPath);
        }
        System.out.printf("%s%n%s%n%s%n", PRS.getProperty("hibernate.connection.url"),
               PRS.getProperty("hibernate.connection.username"), PRS.getProperty("hibernate.connection.password"));

        //Config readData = new Config(prs.getProperty()); отключил Config так как пользуюсь Properties
        // Чтобы заработал getProperties() необходим четкий ключ то есть, key = a[0] (то есть наш Config это аналог Properties,
        // а метод values, аналог Propeties)
        String url = PRS.getProperty("hibernate.connection.url");
        String login = PRS.getProperty("hibernate.connection.username");
        String password = PRS.getProperty("hibernate.connection.password");

        //System.out.printf("%s%n%s%n%s%n", password, url, login); проверка

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }
}
