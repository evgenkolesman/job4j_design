package ru.job4j.solid.lcp.foodstore.store;

import ru.job4j.solid.lcp.foodstore.Food;

import java.util.ArrayList;
import java.util.List;

public class Warehouse implements Store {
    private List<Food> list = new ArrayList<>();

    @Override
    public boolean add(Food food) {
        boolean flag = false;
        if (food.getFreshness() < 25) {
            list.add(food);
            flag = true;
        }
        return flag;
    }

    @Override
    public List<Food> getAll() {
        return list;
    }

    @Override
    public void clear() {
        list.clear();
    }
}

