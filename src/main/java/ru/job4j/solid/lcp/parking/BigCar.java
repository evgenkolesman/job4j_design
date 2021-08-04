package ru.job4j.solid.lcp.parking;

public class BigCar implements Vehicle {
    private int n;

    public BigCar(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    @Override
    public int size() {
        return n;
    }
}
