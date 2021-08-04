package ru.job4j.solid.lcp.parking;

import java.util.ArrayList;
import java.util.List;

/*
 * класс реализация интерфэйса парковки Parking
 * по умолчанию у нас 5 мест, но мы можем расшириться если применим метод
 * countPlace() - возможность планирования потока исходя из бизнес плана
 */
public class Park implements Parking {
    private int bigCarPlace;
    private int smallCarPlace;
    int freeBigCarPlace = bigCarPlace;
    int freeSmallCarPlace = smallCarPlace;
    private List<Vehicle> list = new ArrayList<>();

    public Park(int bigCarPlace, int smallCarPrice) {
        this.bigCarPlace = bigCarPlace;
        this.smallCarPlace = smallCarPrice;
    }

    @Override
    public boolean park(Vehicle vehicle) {
        if (vehicle.getClass() == BigCar.class) {
            freeBigCarPlace = freeBigCarPlace - 1;
            if (freeBigCarPlace == 0) {
                System.out.println("Грузовых мест нет");
            }
        } else if (vehicle.getClass() == LittleCar.class) {
            freeSmallCarPlace = freeSmallCarPlace - 1;
            if (freeSmallCarPlace == 0) {
                System.out.println("Легковых мест нет");
            }
        }
        return false;
    }

    public int getBigCarPlace() {
        return bigCarPlace;
    }

    public int getSmallCarPlace() {
        return smallCarPlace;
    }
}
