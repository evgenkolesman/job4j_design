package ru.job4j.solid.srp.formating;

/*
 * Интерфейс для преобразования теста в различные форматы
 * JSON -> FormateToJSON
 * XML -> FormateToXML
 * HTML -> FormateToHTML
 * @author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 */

public interface Formatting {

    String format();
}
