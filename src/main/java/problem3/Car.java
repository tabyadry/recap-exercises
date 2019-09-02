package problem3;

import java.util.Random;

public class Car {
    private final int MILES_PER_GALLON = 25;

    private double mileage;
    private double gallonsOfGas;
    private boolean isBroken;

    public Car(double gallonsOfGas, double mileage) {
        this.gallonsOfGas = gallonsOfGas;
        this.mileage = mileage;
        isBroken = false;
    }


    public boolean verifyIfCarBreaks(int randomValue) {
        int randomNo = (randomValue + 1) * 10;
        if (randomNo <= getChanceOfBreakdown()) {
            isBroken = true;
        }
        return isBroken;
    }

    /**
     * Attempts to drive # miles, returns true for success or false for fail
     */
    public boolean turnOnAndDrive(int milesToDrive, int randomValue) {
        boolean isSuccessful;
        verifyIfCarBreaks(randomValue);
        if (isBroken) {
            isSuccessful = false;
        } else {
            double milesAbleToDrive = gallonsOfGas * MILES_PER_GALLON;
            if (milesAbleToDrive > milesToDrive) {
                mileage += milesToDrive;
                gallonsOfGas -= milesToDrive / MILES_PER_GALLON;
                isSuccessful = true;
            } else {
                mileage += milesAbleToDrive;
                gallonsOfGas = 0;
                isSuccessful = false;
            }
        }
        return isSuccessful;
    }

    private int getChanceOfBreakdown() {
        return (((int) mileage - 1) / 10000 + 1) * 10;
    }

    /**
     * Returns the number of miles this car has driven.
     */
    public double getMileage() {
        return mileage;
    }

    /**
     * Returns the number of gallons of gas that is inside the car’s gas tank
     */
    public double getGallonsOfGas() {
        return gallonsOfGas;
    }

    /**
     * Returns true if the car is broken down, and false otherwise.
     */
    public boolean isBrokenDown() {
        return isBroken;
    }

    /**
     * Sets the car as no longer broken down
     */
    public void repair() {
        isBroken = false;
    }

    /**
     * Adds the given number of gallons of gas to the car’s gas tank
     */
    public void fillGas(double numberOfGallons) {
        gallonsOfGas += numberOfGallons;
    }
}
