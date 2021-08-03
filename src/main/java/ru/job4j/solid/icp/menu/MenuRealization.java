package ru.job4j.solid.icp.menu;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.*;

public class MenuRealization implements  MenuCreation, ShowMenu, UseMenuItem{
    private List<Item> itemList;

    public MenuRealization(List<Item> itemList) {
        this.itemList = itemList;
    }

    @Override
    public Set<String> createMenu(Map<String, Item> menu) {
        Set<String> fullMenu = new TreeSet<>();
        Queue<String> data = new LinkedList<>(menu.keySet());
        while (!data.isEmpty()) {
            String name = data.poll();
            if (!data.contains(name)) {
                Item submenu = menu.get(name);
                List<String> list = submenu.getItems();
                if (list != null) {
                    list.stream().forEach((s) -> fullMenu.add(name.concat(s)));
                }
                fullMenu.add(submenu.getName());
            }
        }
        return fullMenu;
    }

    @Override
    public void showMenu(Set<String> menu, OutputStream out) {
        try (PrintStream ps = new PrintStream(out)) {
            System.setOut(ps);
            Integer tab = ((TreeSet<String>) menu).first().length();
            for (String s : menu) {
                if (s.length() > tab) {
                    ps.println("---".concat(s));
                } else {
                    ps.println(s);
                    tab = s.length();
                }
            }
        }
    }

    @Override
    public void select(String name) {
        Item item = null;
        int i = 0;
        while (item == null && itemList != null && i < itemList.size()) {
            if (itemList.get(i++).getName().equals(name)) {
                item = itemList.get(i++);
            }
        }
        execute(item);
    }

    @Override
    public void execute(Item item) {
        System.out.println("Здесь должна быть реализация меню с объектом " + item.toString() );
    }
}
