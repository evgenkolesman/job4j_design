package ru.job4j.solid.lcp.parking;

/*
 * класс реализация интерфэйса парковки Parking
 * по умолчанию у нас 5 мест, но мы можем расшириться если применим метод
 * countPlace() - возможность планирования потока исходя из бизнес плана
 */
public class Park implements Parking {
    private int bigCarPlace;
    private int smallCarPlace;
    private Vehicle[] freeBigCarPlace;
    private Vehicle[] freeSmallCarPlace;

    public Park(int bigCarPlaceIn, int smallCarPlaceIn) {
        this.bigCarPlace = 0;
        this.smallCarPlace = 0;
        this.freeBigCarPlace = new Vehicle[bigCarPlaceIn];
        this.freeSmallCarPlace = new Vehicle[smallCarPlaceIn];
    }

    @Override
    public boolean park(Vehicle vehicle) {
        boolean flag = false;
        if (vehicle.size() == 1 && smallCarPlace < freeSmallCarPlace.length) {
            freeSmallCarPlace[smallCarPlace++] = vehicle;
            flag = true;
        }
        if (vehicle.size() > 1 && bigCarPlace < freeBigCarPlace.length) {
            freeBigCarPlace[bigCarPlace++] = vehicle;
            flag = true;
        } else if (vehicle.size() <= freeSmallCarPlace.length - smallCarPlace) {
            for (int i = 0; i < vehicle.size(); i++) {
                freeSmallCarPlace[smallCarPlace++] = vehicle;
                flag = true;
            }
        }
        return flag;
    }
}
