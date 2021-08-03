package ru.job4j.solid.icp.menu;

public interface UseMenuItem {
    void select(String name);

    void execute(Item item);
}
