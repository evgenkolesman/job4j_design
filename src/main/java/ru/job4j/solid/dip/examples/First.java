package ru.job4j.solid.dip.examples;

import ru.job4j.solid.lcp.foodstore.Food;
import ru.job4j.solid.lcp.foodstore.store.Shop;

/*
 * Делаем хранилище типа магазин
 * и питание
 *
 */
public class First {
    private Shop shop; // лучше применить Store Store потмоу
    // что будет абстарцией, будет возможность данный магазин преобразовать вдругое
    // хранилище
    private Food food;

    public First(Shop shop, Food food) {
        this.shop = shop;
        this.food = food;
    }
}
