package ru.job4j.solid.icp.menu;

import java.util.List;

public class Item {
    private String name;
    private List<String> items;

    public Item(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }

    public Item(String name) {
        this.name = name;
    }

    public List<String> getItems() {
        return items;
    }

    public String getName() {
        return name;
    }
}
