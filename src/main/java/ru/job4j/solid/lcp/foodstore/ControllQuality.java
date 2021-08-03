package ru.job4j.solid.lcp.foodstore;

import java.util.Date;
import java.util.List;

/*
 * Этот метод делает ярлычки свежести для нашей системы хранения исходя,
 * каждый ярлычок мы вносим в продукт путем setFreshness()
 * на основании этого ярлычка будет произведена сортировка
 * @ Kolesnikov Evgeniy evgeniysanich@mail.ru
 * @ version 1
 */
public class ControllQuality<countFreshnes> {
    private int storageLife; // количество в днях годности продукта
    private int nowDateProductLife; // осталось времени в днях годности
    private Date date = new Date();
    private List<Food> food;

    public ControllQuality(List<Food> food) {
        // конструктор получает данные в днях
        this.food = food;
    }

    public void countFreshness() {
        if( !food.isEmpty()) {
            for (Food first : food) {
                storageLife = (int) ((first.getExpirityDate().getTimeInMillis() - first.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
                nowDateProductLife = (int) (date.getTime()
                        - first.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000);
                if (date.after(first.getExpirityDate().getTime())) {
                    first.setFreshness(100);
                } else {
                    first.setFreshness(nowDateProductLife * 100 / storageLife);
                }   // получаем процентаж
            }
        }
    }

}


