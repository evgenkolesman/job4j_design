package ru.job4j.solid.icp.examples.third;

import java.io.File;

public interface DataAnalize {

   String getData(String data); // принимаем данные на вход

   boolean comparingData(); // сопоставляем по важности

   String report(String data); // делаем аналитический отчет

   String writeData(File file);
   //записывае необходимые данные в файл - этот интерфейс
   // я бы выделил вместе с report,  так как в интерфейсе рекомендуется не более 3х методов
   // и в этих методах задача уже сводиться к формированию и записи отчета
}
