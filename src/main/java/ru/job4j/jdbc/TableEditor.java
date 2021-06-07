package ru.job4j.jdbc;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/*Настройка, взаимодействие с JDBC, SQL
 * симулярую работу в PostgresSQL
 * Соединение от Properties, создание таблицы, удаление таблицы, внесение данных(колонки),
 * удаление колонки, отключение. Форматирование под переменные...
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public class TableEditor implements AutoCloseable {

    private final String file = "app.properties";
    private Connection connection;
    private Properties properties = new Properties();

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream loadPath = loader.getResourceAsStream(file)) {
            properties.load(loadPath);
        }
        connection = DriverManager.getConnection(
                properties.getProperty("hibernate.connection.url"),
                properties.getProperty("hibernate.connection.username"),
                properties.getProperty("hibernate.connection.password"));
    }

    public void createTable(String tableName) throws SQLException {
        writeSQL(String.format("create table if not exists %s (%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"));
    }

    public void dropTable(String tableName) throws SQLException {
        writeSQL(String.format("drop table if exists %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        writeSQL(String.format("alter table %s add column if not exists %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        writeSQL(String.format("alter table %s drop column if exists %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        writeSQL(String.format(
                "alter table %s rename column %s to %s;", tableName, columnName, newColumnName));
    }

    public void writeSQL(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }
}
