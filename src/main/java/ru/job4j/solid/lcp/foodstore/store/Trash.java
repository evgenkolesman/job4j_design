package ru.job4j.solid.lcp.foodstore.store;

import ru.job4j.solid.lcp.foodstore.ControllQuality;
import ru.job4j.solid.lcp.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public class Trash implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        ControllQuality cq = new ControllQuality(food);
        if (cq.getFreshness() >= 100) {
            list.add(food);
        }
    }

    @Override
    public List<Food> getAll() {
        if (list.size() != 0) {
            for (int i = 0; i < list.size(); i++) {
                return list;
            }
        }
        return null;
    }
}
