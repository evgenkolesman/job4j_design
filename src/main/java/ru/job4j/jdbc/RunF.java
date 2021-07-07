package ru.job4j.jdbc;

/*
 * Класс создан для запуска Demo классов
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */
public class RunF {
    public static void main(String[] args) throws Exception {
        PrepareStatementDemo a = new PrepareStatementDemo();
        City c1 = new City(1, "voronezh", 1000000);
        a.insert(c1);
        City c2 = new City(2, "volgograd", 900000);
        a.insert(c2);
        City c3 = new City(3, "rostov-na-donu", 1500000);
        a.insert(c3);
        a.delete(3);
        System.out.println(a.findAll());
    }

    /*main к первому Demo упражнению
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        TableEditor a = new TableEditor(properties);
       a.createTable("tableex");
        a.addColumn("tableex", "e", "name");
        a.dropColumn("tableex", "e");
        //a.renameColumn("TableEx", "Third", "Second");
        //a.dropTable("TableEx");
        System.out.println(a.getScheme("tableex"));
        a.close();
    }*/
}
