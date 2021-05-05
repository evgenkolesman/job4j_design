package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/* Slf4j - вывод переменных
 * Реализацияи вывода 8 разных типов данных ,использование библиотеки slf4j
 *@author Kolesnikov Evgeniy (evgeniysanich@mail.ru)
 * @version 1.0
 * 05.05.2021
 */
public class UsageLog4j {

    //private static final Logger LOG = LogManager.getLogger(UsageLog4j.class.getName());
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Evgeniy Kolesnikov";
        int age = 33;
        short number = 1;
        Calendar birthday = new GregorianCalendar(1987, 11, 10);
        Date date = birthday.getTime();
        double height = 1.7;
        long daysLive = age * 365;
        boolean isMan = true;
        char liter = 49;
        LOG.debug(
                "User info name : {}, age : {}, number : {}, birthday : {}, height : {}, daysLive : {}, isMan : {}, liter : {}",
                name, age, number, date, height, daysLive, isMan, liter);
    }
}
