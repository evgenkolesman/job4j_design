package ru.job4j.solid.lcp.parking;

public class BigCar implements Vehicle {



    public BigCar(int n) {
        this.n = n;
    }

    public int getN() {
        return n;
    }

    private int n;
    @Override
    public int size() {
        return n;
    }
}
