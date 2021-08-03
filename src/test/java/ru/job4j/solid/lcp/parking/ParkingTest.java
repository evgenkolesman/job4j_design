package ru.job4j.solid.lcp.parking;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ParkingTest {

   @Test
   public void carParkingTest() {
       Parking parking = new Park();
       Vehicle litleCar = new LittleCar();
       Vehicle bigCar = new BigCar();
       assertEquals(parking.park(litleCar), true);
       assertEquals(parking.park(bigCar), true);
   }

   @Test
    public void carParkingTooMany() {
       Park parkPlace = new Park();
       Vehicle litleCar = new LittleCar();
       Vehicle bigCar = new BigCar();
       Vehicle bigCar1 = new BigCar();
       Vehicle bigCar2 = new BigCar();
       Vehicle bigCar3 = new BigCar();
       List<Vehicle> vehicleList = List.of(litleCar, bigCar, bigCar1, bigCar2, bigCar3);

       assertEquals(parkPlace.park(vehicleList.get(0)), true);
       assertEquals(parkPlace.park(vehicleList.get(1)), true);
       assertEquals(parkPlace.park(vehicleList.get(2)), true);
       assertEquals(parkPlace.park(vehicleList.get(3)), false);
       parkPlace.countFreeSize(vehicleList);
       assertEquals(parkPlace.park(bigCar3), true);
   }



}