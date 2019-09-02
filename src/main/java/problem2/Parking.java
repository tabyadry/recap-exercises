package problem2;

import java.util.ArrayList;
import java.util.List;

public interface Parking {

    boolean isParkingPlaceAvailable(Vehicle vehicle);
    boolean parkCar(Car car);
    boolean parkBus(Bus bus);
}
