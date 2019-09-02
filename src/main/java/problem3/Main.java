package problem3;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        System.out.println(main.testCar());
    }

    public double testCar() {
        Car myCar = new Car(10.0, 0.0);

        int milesToDrive = 10;
        while (!myCar.isBrokenDown()) {
            if (myCar.getGallonsOfGas() == 0.0) {
                myCar.fillGas(10.0);
            }
            myCar.turnOnAndDrive(milesToDrive, new Random().nextInt(10));
            milesToDrive += 10;
        }
        return myCar.getMileage();
    }
}
