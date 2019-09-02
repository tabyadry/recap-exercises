package problem2;

public class Bus extends Vehicle {
    public static final int NO_OF_OCCUPIED_SPACIES = 5;

    //the starting no of the parkingPosition of the bus
    private int parkingPosition;

    public Bus(String immatriculationNo) {
        super(immatriculationNo);
    }

    public int getParkingPosition() {
        return parkingPosition;
    }

    public void setParkingPosition(int parkingPosition) {
        this.parkingPosition = parkingPosition;
    }
}
