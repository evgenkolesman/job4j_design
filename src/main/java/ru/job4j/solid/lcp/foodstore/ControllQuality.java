package ru.job4j.solid.lcp.foodstore;

import ru.job4j.solid.lcp.foodstore.store.Store;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Этот метод делает ярлычки свежести для нашей системы хранения исходя,
 * каждый ярлычок мы вносим в продукт путем setFreshness()
 * на основании этого ярлычка будет произведена сортировка
 * добавлен resort() производит пересортировку товаров
 *
 * @version 1
 * @Kolesnikov Evgeniy evgeniysanich@mail.ru
 */
public class ControllQuality {
    private Date date = new Date();
    private List<Store> storesList;

    public ControllQuality(List<Store> storesList) {
        this.storesList = storesList;
    }

    public void countFreshness(Food food) {
        // количество в днях годности продукта
        int storageLife = (int) ((food.getExpirityDate().getTimeInMillis() - food.getCreateDate().getTimeInMillis()) / (24 * 60 * 60 * 1000));
        // осталось времени в днях годности
        int nowDateProductLife = (int) (date.getTime()
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
        for (Store s : storesList) {
            foodList.addAll(s.getAll());
            s.clear();
        }
        foodList.forEach(this::distribute);
    }
}




