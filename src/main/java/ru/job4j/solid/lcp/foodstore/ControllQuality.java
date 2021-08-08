package ru.job4j.solid.lcp.foodstore;

import ru.job4j.solid.lcp.foodstore.store.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
 * Этот метод делает ярлычки свежести для нашей системы хранения исходя,
 * каждый ярлычок мы вносим в продукт путем setFreshness()
 * на основании этого ярлычка будет произведена сортировка
 * @Kolesnikov Evgeniy evgeniysanich@mail.ru
 * @version 1
 */
public class ControllQuality {
    private int storageLife; // количество в днях годности продукта
    private int nowDateProductLife; // осталось времени в днях годности
    private Date date = new Date();
    private List<Store> storesList;

    public ControllQuality(List<Store> storesList) {
        this.storesList = storesList;
    }

    public void countFreshness(Food food) {
        storageLife = (int) ((food.getExpirityDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
        nowDateProductLife = (int) (date.getTime()
                - food.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000);
        if (date.after(food.getExpirityDate().getTime())) {
            food.setFreshness(100);
        } else {
            food.setFreshness(nowDateProductLife * 100 / storageLife);
        }   // получаем процентаж
    }

    public void distribute(Food food) {
        countFreshness(food);
        for (Store s : storesList) {
            s.add(food);
        }
    }

    public void resort() {
        List<Food> foodList = new ArrayList<>();
        for(Store s : storesList) {
            s.getAll().forEach(foodList :: add);
            s.clear();
        }
        foodList.forEach(this::distribute);
    }
}




