package ru.job4j.solid.icp.menu;

import java.util.List;
import java.util.Map;

public interface MenuCreation {

    List<String> createMenu(Map<String, Item> menu);
}
