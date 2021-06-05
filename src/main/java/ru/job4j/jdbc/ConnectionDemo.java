package ru.job4j.jdbc;

import ru.job4j.io.Config;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/*Настройка, взаимодействие с JDBC, SQL
 *Программа считывает строки из C:\projects\job4j_design\app.properties,
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
    private static final String FILE = "C:\\projects\\job4j_design\\src\\main\\resources\\app.properties";
    private static String url;
    private static String login;
    private static String password;
    private static List<String> listadd = new ArrayList<>();
    private static final Properties prs = new Properties();

    public static void main(String[] args) throws ClassNotFoundException, SQLException, Exception {
        Class.forName("org.postgresql.Driver");
        /*не работает способ ухождения от  абсолютного пути не пойму почему..
        ConnectionDemo settings = new ConnectionDemo();
        ClassLoader loader = ConnectionDemo.class.getClassLoader();
        try(InputStream loadPath = loader.getResourceAsStream("app.properties")) {
            settings.load(loadPath);
            System.out.println(settings.getValue());
        }
            String path = settings.getValue();

         */
        Config readData = new Config(FILE);
        readLine(readData.toString());
        getData();
        System.out.printf("%s%n%s%n%s%n", password, url, login);
        /*String url = "jdbc:postgresql://localhost:5432/idea_db";
        String login = "postgres";
        String password = "PassworD1";*/

        try (Connection connection = DriverManager.getConnection(url, login, password)) {
            DatabaseMetaData metaData = connection.getMetaData();
            System.out.println(metaData.getUserName());
            System.out.println(metaData.getURL());
        }
    }

    private static void getData() {
        for (String ar : listadd) {
            if (ar.contains("url")) {
                String[] url1 = ar.split("=");
                url = url1[1];
            }
            if (ar.contains("password")) {
                String[] password1 = ar.split("=");
                password = password1[1];
            }
            if (ar.contains("username") && (!ar.startsWith("#"))) {
                String[] login1 = ar.split("=");
                login = login1[1];
            }
        }
    }

    private static void readLine(String string) {
        try (BufferedReader br = new BufferedReader(new StringReader(string))) {
            String a;
            while ((a = br.readLine()) != null) {
                listadd.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void load(InputStream data) {
        try {
            prs.load(data);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getValue() {
        return prs.getProperty(ConnectionDemo.FILE);
    }
}
