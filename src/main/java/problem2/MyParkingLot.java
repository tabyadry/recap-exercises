package problem2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyParkingLot implements Parking {
    public static final int PARKING_CAPACITY = 100;
    public static final Boolean EMPTY = false;
    public static final Boolean OCCUPIED = true;

    private final Boolean[] parkingLot = new Boolean[PARKING_CAPACITY];

    public MyParkingLot() {
        Arrays.fill(parkingLot, EMPTY);
    }

    @Override
    public boolean isParkingPlaceAvailable(Vehicle vehicle) {
        if (vehicle instanceof Car) {
            for (Boolean b : parkingLot) {
                if (b == false) return true;
            }
        } else if (vehicle instanceof Bus) {
            int count = 0;
            int i = PARKING_CAPACITY - 1;
            while (count < 5 && i >= 0) {
                if (i % 10 == 9) count = 0; // buses can be parked just on 5 spaces between %0-%9 of each line
                if (parkingLot[i] == EMPTY) {
                    count++;
                } else {
                    count = 0;
                }
                i--;
            }
            if (count == 5) return true;
        }
        return false;
    }

    @Override
    public boolean parkCar(Car car) {
        int i = 0;
        while (i < PARKING_CAPACITY) {
            if (parkingLot[i] == EMPTY) {
                car.setParkingPosition(i);
                parkingLot[i] = OCCUPIED;
                return true;
            }
            i++;
        }

        return false;
    }

    @Override
    public boolean parkBus(Bus bus) {
        int count = 0;
        int i = PARKING_CAPACITY - 1;
        while (count < 5 && i >= 0) {
            if (i % 10 == 9) count = 0; // buses can be parked just on 5 spaces between %0-%9 of each line
            if (parkingLot[i] == EMPTY) {
                count++;
            } else {
                count = 0;
            }
            i--;
        }
        if (count == 5) {
            bus.setParkingPosition(i + 1);
            for (int k = 0; k < Bus.NO_OF_OCCUPIED_SPACIES; k++) {
                parkingLot[i + 1 + k] = OCCUPIED;
            }
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("PARKING LOT\n");
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < 10; j++)
                stringBuilder.append(" " + parkingLot[i * 10 + j]);
            stringBuilder.append("\n");
        }

        return stringBuilder.toString();
    }
}
