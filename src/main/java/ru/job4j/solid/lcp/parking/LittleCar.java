package ru.job4j.solid.lcp.parking;

public class LittleCar implements Vehicle {
    private String id;

    public LittleCar(String id) {
        this.id = id;
    }

    @Override
    public int size() {
        return 1;
    }

    @Override
    public String getIdCar() {
        return null;
    }
}
