package ru.job4j.solid.lcp.examples.first;

public class OrderStockValidator {

    public boolean isValid(Order order) {
        for (Item item : order.getItems()) {
            if (!item.isInStock()) {
                return false;
            }
        }

        return true;
    }
}

