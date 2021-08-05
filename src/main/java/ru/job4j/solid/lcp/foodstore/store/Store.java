package ru.job4j.solid.lcp.foodstore.store;


import ru.job4j.solid.lcp.foodstore.Food;

import java.util.List;

public interface Store {
    boolean add(Food food);

    List<Food> getAll();
}
