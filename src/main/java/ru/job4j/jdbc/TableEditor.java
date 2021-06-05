package ru.job4j.jdbc;

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

    private Connection connection;

    private final Properties properties;

    public TableEditor(Properties properties) {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            connection = DriverManager.getConnection(
                    properties.getProperty("url"),
                    properties.getProperty("login"),
                    properties.getProperty("password"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void createTable(String tableName) throws SQLException {
        writeSQL(String.format("create table if not %s(%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"));
    }

    public void dropTable(String tableName) throws SQLException {
        writeSQL(String.format("drop table %s;", tableName));
    }

    public void addColumn(String tableName, String columnName, String type) throws SQLException {
        writeSQL(String.format("ALTER TABLE %s ADD %s %s;", tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        writeSQL(String.format("delete from %s where name = %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        writeSQL(String.format(
                "ALTER TABLE %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName));
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
