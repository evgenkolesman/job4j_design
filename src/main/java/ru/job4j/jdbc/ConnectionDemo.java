package ru.job4j.jdbc;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
    private static final File FILE = new File("C:\\projects\\job4j_design\\src\\main\\resources\\app.properties");
    private static String url;
    private static String login;
    private static String password;
    private static List<String> listadd = new ArrayList<>();

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.postgresql.Driver");
        readLine();
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

    private static void readLine() {
        try (BufferedReader br = new BufferedReader(new FileReader(FILE))) {
            String a;
            while ((a = br.readLine()) != null) {
                listadd.add(a);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
