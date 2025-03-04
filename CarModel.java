import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class CarModel {
    ArrayList<Workshop> workshops = new ArrayList<>();
    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<Observer> observers = new ArrayList<>();
    ArrayList<Image> ImageList = new ArrayList<>();


    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(gas);
        }
    }

    void setTurboOn() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOn();
            }

        }
    }

    void setTurboOff() {
        for (Vehicle car : cars) {
            if (car instanceof Saab95) {
                ((Saab95) car).setTurboOff();
            }

        }
    }

    void startEngine() {
        for (Vehicle car : cars) {
            car.startEngine();
        }
    }

    void stopEngine() {
        for (Vehicle car : cars) {
            car.stopEngine();
        }
    }

    void turnRight() {
        for (Vehicle car : cars) {
            car.turnRight();
        }
    }

    void turnLeft() {
        for (Vehicle car : cars) {
            car.turnLeft();

        }
    }
    void adjustTipper(int amount) {
        for (Vehicle car : cars){
            if (car instanceof Scania) {
                ((Scania) car).adjustTipper(amount);
            }

        }
    }

    boolean workshopCollisionCheck(Vehicle car, Workshop workshop) {

        if (Math.abs((workshop.getxPos() - car.getxPos())) < 100 && Math.abs((workshop.getyPos() - car.getyPos())) < 70 ){
            return true;
        }


        return false;
    }

}

