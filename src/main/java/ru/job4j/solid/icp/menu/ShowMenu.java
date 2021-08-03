package ru.job4j.solid.icp.menu;

import java.io.OutputStream;
import java.util.Set;

public interface ShowMenu {
    void showMenu(Set<String> menu, OutputStream out);
}
