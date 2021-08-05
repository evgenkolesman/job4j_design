package ru.job4j.solid.lcp.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ParkingTest {

    @Test
    public void carParkingTest() {
        Parking parking = new Park(2, 1);
        Vehicle litleCar = new LittleCar("2");
        Vehicle bigCar = new BigCar(2, "1");
        assertEquals(parking.park(litleCar), true);
        assertEquals(parking.park(bigCar), true);
    }

    @Test
    public void carParkingTooMany() {
        Park parkPlace = new Park(2, 1);
        Vehicle litleCar = new LittleCar("1");
        Vehicle bigCar = new BigCar(2, "2");
        Vehicle bigCar1 = new BigCar(2, "3");
        Vehicle bigCar2 = new BigCar(2, "4");
        Vehicle bigCar3 = new BigCar(2, "5");
        List<Vehicle> vehicleList = List.of(litleCar, bigCar, bigCar1, bigCar2, bigCar3);

        assertEquals(parkPlace.park(vehicleList.get(0)), true);
        assertEquals(parkPlace.park(vehicleList.get(1)), true);
        assertEquals(parkPlace.park(vehicleList.get(2)), true);
        assertEquals(parkPlace.park(vehicleList.get(3)), false);
    }

    @Test
    public void carBigToLitlePlace() {
        Park parkPlace = new Park(0, 4);
        List<Vehicle> list = List.of(new BigCar(2, "1"), new BigCar(2, "2"));
        assertEquals(parkPlace.park(list.get(0)), true);
        assertEquals(parkPlace.park(list.get(1)), true);
        Vehicle bigCarOver = new BigCar(2, "3");
        assertEquals(parkPlace.park(bigCarOver), false);
    }
}