package problem2;

public class Car extends Vehicle {
    private static final int NO_OF_OCCUPIED_SPACIES = 1;
    private int parkingPosition;

    public Car(String immatriculationNo) {
        super(immatriculationNo);
    }

    public void setParkingPosition(int parkingPosition) {
        this.parkingPosition = parkingPosition;
    }

    public int getParkingPosition() {
        return parkingPosition;
    }
}
