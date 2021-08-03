package ru.job4j.solid.icp.menu;

import java.util.List;

public class Item {
    private String name;

    public Item(String name, List<String> items) {
        this.name = name;
        this.items = items;
    }

    public Item(String name) {
        this.name = name;
    }

    private List<String> items;


}
