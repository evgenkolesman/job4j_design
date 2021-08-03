package ru.job4j.solid.lcp.foodstore;

import ru.job4j.solid.lcp.foodstore.store.Shop;
import ru.job4j.solid.lcp.foodstore.store.Trash;
import ru.job4j.solid.lcp.foodstore.store.Warehouse;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;

public class FoodStoreWork {
    public static void main(String[] args) {
        Food milk = new Food("Milk", new GregorianCalendar(2021, Calendar.JULY, 21),
                new GregorianCalendar(2022, Calendar.JANUARY, 21), 100, 0.5);
        Food cheese = new Food("Cheese", new GregorianCalendar(2021, Calendar.MAY, 21),
                new GregorianCalendar(2021, Calendar.AUGUST, 5), 200, 0.3);
        Food tomato = new Food("Tomato", new GregorianCalendar(2020, Calendar.AUGUST, 01),
                new GregorianCalendar(2020, Calendar.JULY, 19), 190, 0.3);
        Warehouse warehouse = new Warehouse();
        Trash trash = new Trash();
        Shop shop = new Shop();
        List<Food> foodList = List.of(milk, cheese, tomato);
        ControllQuality cq = new ControllQuality(foodList);
        cq.countFreshness();
        for (Food a : foodList) {
            shop.add(a);
            trash.add(a);
            warehouse.add(a);
        }
        if (shop.getAll() != null) {
            System.out.println("Shop consists of: ");
            shop.getAll().stream().forEach(System.out::println);
        }
        if (trash.getAll() != null) {
            System.out.println("Trash consists of: ");
            trash.getAll().stream().forEach(System.out::println);
        }
        if (warehouse.getAll() != null) {
            System.out.println("Warehouse consists of: ");
            warehouse.getAll().stream().forEach(System.out::println);
        }
    }
}
