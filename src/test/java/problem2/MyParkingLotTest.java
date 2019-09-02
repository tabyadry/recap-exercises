package problem2;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class MyParkingLotTest {
    MyParkingLot myParkingLot;

    @Before
    public void init() {
        myParkingLot = new MyParkingLot();
    }

    @Test
    public void isParkingPlaceAvailableForACar() {
        System.out.println("The parking lot before assert in isParkingPlaceAvailableForACar:\n" + myParkingLot);
        assertTrue(myParkingLot.isParkingPlaceAvailable(new Car("CJ 18 JPD")));
    }

    @Test
    public void isParkingPlaceAvailableForABus() {
        System.out.println("The parking lot before assert in isParkingPlaceAvailableForABus:\n" + myParkingLot);
        assertTrue(myParkingLot.isParkingPlaceAvailable(new Bus("CJ 18 JPD")));
    }

    @Test
    public void isParkingPlaceNotAvailableForABus() {
        for (int i = 0; i < 20; i++)
            myParkingLot.parkBus(new Bus("PH 18 JPD"));

        System.out.println("The parking lot before assert in isParkingPlaceAvailableForABus:\n" + myParkingLot);
        assertFalse(myParkingLot.isParkingPlaceAvailable(new Bus("CJ 18 JPD")));
    }

    @Test
    public void isParkingPlaceNotAvailableForABus2() {
        for (int i = 0; i < 19; i++)
            myParkingLot.parkBus(new Bus("PH 18 JPD"));
        myParkingLot.parkCar(new Car("MM 97 SKL"));

        Vehicle vehicle = new Bus("SV 32 SVF");

        System.out.println("The parking lot before assert in isParkingPlaceAvailableForABus:\n" + myParkingLot);
        assertFalse(myParkingLot.isParkingPlaceAvailable(vehicle));
    }

    @Test
    public void parkCar() {
        assertTrue(myParkingLot.parkCar(new Car("CJ 18 JPD")));
        System.out.println(myParkingLot);
    }

    @Test
    public void parkBus() {
        assertTrue(myParkingLot.parkBus(new Bus("PH 18 JPD")));
        System.out.println(myParkingLot);
    }

    @Test
    public void canNotParkBus() {
        for (int i = 0; i < 19; i++)
            myParkingLot.parkBus(new Bus("PH 18 JPD"));
        myParkingLot.parkCar(new Car("MM 97 SKL"));
        System.out.println("The parking lot before assert in canNotParkBus:\n" + myParkingLot);
        assertFalse(myParkingLot.parkBus(new Bus("PH 18 JPD")));
    }
}