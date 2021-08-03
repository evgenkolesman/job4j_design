package ru.job4j.solid.lcp.parking;

import java.util.ArrayList;
import java.util.List;

/*
 * класс реализация интерфэйса парковки Parking
 * по умолчанию у нас 5 мест, но мы можем расшириться если применим метод
 * countPlace() - возможность планирования потока исходя из бизнес плана
 */
public class Park implements Parking {
    private int freeSize = 5;
    int freeSizePark;
    private List<Vehicle> list = new ArrayList<>();

    @Override
    public boolean park(Vehicle vehicle) {
        freeSizePark = freeSize;
        for (Vehicle a : list) {
            freeSizePark -= a.size();
            if (freeSizePark < 0) {
                return false;
            } else {
                list.add(vehicle);
                return true;
            }
        }
        return false;
    }

    public void countFreeSize(List<Vehicle> vehicleList) {
        int freeSizeCount = 0;
        if (!vehicleList.isEmpty()) {
            for (Vehicle a : vehicleList) {
                freeSizeCount += a.size();
            }
            if (freeSizeCount > freeSize) {
                freeSize = freeSizeCount;
            } else {
                System.out.println("При расчетах получилось значение меньше стандартного," +
                        " оставляем стандарт");
            }
        }
    }

    public int getFreeSize() {
        return freeSize;
    }
}
