package ru.job4j.solid.icp.menu;

public interface UseMenuItem {
    Item select(Item name);

    void execute(Item item);
}
