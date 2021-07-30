package ru.job4j.lcp.examples.foodstore.store;

import ru.job4j.lcp.examples.foodstore.ControllQuality;
import ru.job4j.lcp.examples.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public void add(Food food) {
        ControllQuality cq = new ControllQuality(food);
        if (cq.getFreshness() < 25) {
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
