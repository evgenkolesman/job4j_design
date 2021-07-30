package ru.job4j.lcp.examples.foodstore;

import java.util.Calendar;

public class ControllQuality {
    private int diffProc; // количество в днях годности продукта
    private int nowDateControlProc; // осталось времени в днях годности

    public ControllQuality(Food food) {
        // конструктор получает данные в днях
        this.diffProc = (int) ((food.getExpirityDate().getTime().getTime() - food.getCreateDate().getTime().getTime()) / (24 * 60 * 60 * 1000));
        this.nowDateControlProc = (int) ((Calendar.getInstance().getTime().getTime() - food.getCreateDate().getTime().getTime()) / (24 * 60 * 60 * 1000));
    }

    public long getFreshness() {
        return diffProc / nowDateControlProc * 100; // получаем процентаж
    }
}

