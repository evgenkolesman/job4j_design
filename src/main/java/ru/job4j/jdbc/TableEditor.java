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

    private static final String FILE = "app.properties";
    private static Connection connection;
    private static Properties PROPERTIES = new Properties();

    public TableEditor(Properties properties) throws Exception {
        this.PROPERTIES = properties;
        initConnection();
    }

    private static void initConnection() throws Exception {
        Class.forName("org.postgresql.Driver");
        ClassLoader loader = TableEditor.class.getClassLoader();
        try (InputStream loadPath = loader.getResourceAsStream(FILE)) {
            PROPERTIES.load(loadPath);
        }
        System.out.println(PROPERTIES.getProperty("hibernate.connection.url"));
        connection = DriverManager.getConnection(
                PROPERTIES.getProperty("hibernate.connection.url"),
                PROPERTIES.getProperty("hibernate.connection.username"),
                PROPERTIES.getProperty("hibernate.connection.password"));
    }


    public static void createTable(String tableName) throws SQLException {
        writeSQL(String.format("CREATE TABLE IF NOT EXISTS %s(%s, %s);",
                tableName,
                "id serial primary key",
                "name varchar(255)"));
    }

    public void dropTable(String tableName) throws SQLException {
        writeSQL(String.format("DROP TABLE IF EXISTS %s;", tableName));
    }

    public static void addColumn(String tableName, String columnName, String type) throws SQLException {
        writeSQL(String.format("ALTER TABLE  %s ADD IF NOT EXISTS %s %s;",  tableName, columnName, type));
    }

    public void dropColumn(String tableName, String columnName) throws SQLException {
        writeSQL(String.format("ALTER DROP from %s where name = %s;", tableName, columnName));
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws SQLException {
        writeSQL(String.format(
                "ALTER TABLE  IF NOT EXISTS %s RENAME COLUMN %s TO %s;", tableName, columnName, newColumnName));
    }

    public static void writeSQL(String sql) throws SQLException {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static String getScheme(String tableName) throws SQLException {
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

    public static void main(String[] args) throws Exception {
        //initConnection();
        TableEditor a = new TableEditor(PROPERTIES);
        a.createTable("TableEx" );
        a.addColumn("TableEx", "First", "name");
        //a.dropTable("TableEx");
        System.out.println(getScheme("TableEx"));

    }
}
