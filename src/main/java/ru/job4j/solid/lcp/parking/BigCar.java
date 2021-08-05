package ru.job4j.solid.lcp.parking;

public class BigCar implements Vehicle {
    private int n;
    private String id;

    public BigCar(int n, String id) {
        this.n = n;
        this.id = id;
    }

    public int getN() {
        return n;
    }

    @Override
    public int size() {
        return n;
    }

    @Override
    public String getIdCar() {
        return null;
    }
}
