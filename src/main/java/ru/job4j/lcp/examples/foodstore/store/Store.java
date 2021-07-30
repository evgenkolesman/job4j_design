package ru.job4j.lcp.examples.foodstore.store;

import ru.job4j.lcp.examples.foodstore.Food;

import java.util.List;

public interface Store {
    void add(Food food);

    List<Food> getAll();
}
