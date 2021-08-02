package ru.job4j.solid.lcp.foodstore;

import java.util.Date;

public class ControllQuality {
    private int diffProc; // количество в днях годности продукта
    private int nowDateControlProc; // осталось времени в днях годности
    private Date date = new Date();

    public ControllQuality(Food food) {
        // конструктор получает данные в днях
        this.diffProc = (int) ((food.getExpirityDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
        this.nowDateControlProc = (int) (date.getTime() - food.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000);
    }

    public long getFreshness() {
        if (nowDateControlProc > 0 && diffProc > 0) {
            return nowDateControlProc / diffProc * 100;
        } else if (diffProc < 0) {
            return 100;
        } else {
            throw new IllegalArgumentException("Не верные данные о товаре,"
                    + " дата производства еще не пришла");
        }   // получаем процентаж
    }
}


