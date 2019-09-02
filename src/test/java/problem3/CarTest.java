package problem3;

import org.junit.Before;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.*;

public class CarTest {
    Car car;

    @Before
    public void setUp() throws Exception {
        car = new Car(10.0, 1000.0);
    }

    @Test
    public void turnOnAndDrive() {
        int randomValue = new Random().nextInt(10);
        boolean isBroken = car.verifyIfCarBreaks(randomValue);

        assertEquals(!isBroken, car.turnOnAndDrive(25, randomValue));
        System.out.println(car.getMileage());
        System.out.println(car.getGallonsOfGas());

    }
    @Test
    public void turnOnAndDrive2() {
        int randomValue = new Random().nextInt(10);
        boolean isBroken = car.verifyIfCarBreaks(randomValue);

        assertEquals(false, car.turnOnAndDrive(250, randomValue));
        System.out.println(car.getMileage());
        System.out.println(car.getGallonsOfGas());

    }

    @Test
    public void getMileage() {
        assertEquals(1000.0, car.getMileage(), 0.1);
    }

    @Test
    public void getGallonsOfGas() {
        assertEquals(10.0, car.getGallonsOfGas(), 0.1);

    }

    @Test
    public void isBrokenDown() {
        assertEquals(false, car.isBrokenDown());
    }

    @Test
    public void repair() {
        car.repair();
        assertEquals(false, car.isBrokenDown());
    }

    @Test
    public void fillGas() {
        car.fillGas(10);
        assertEquals(20.0, car.getGallonsOfGas(), 0.1);
    }
}