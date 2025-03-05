import javax.swing.*;
import java.util.ArrayList;


public class CarModel {
    private ArrayList<Workshop> workshops = new ArrayList<>();
    private ArrayList<Vehicle> cars = new ArrayList<>(10);
    private ArrayList<Observer> observers = new ArrayList<>();


    public CarModel() {


    }

    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    public ArrayList<Observer> getObservers() {
        return observers;
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
    }

    public ArrayList<Workshop> getWorkshops() {
        return workshops;
    }

    public void addCar(Vehicle car) {
        cars.add(car);
    }
    public void addWorkshop(Workshop workshop) {
        workshops.add(workshop);
    }
    public void removeCar(Vehicle car) {
        if (!cars.isEmpty()) {
            this.getCars().remove(car);
        }
    }

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
        for (Vehicle car : cars) {
            if (car instanceof Scania) {
                ((Scania) car).adjustTipper(amount);
            }

        }
    }

    boolean workshopCollisionCheck(Vehicle car, Workshop workshop) {

        if (Math.abs((workshop.getxPos() - car.getxPos())) < 100 && Math.abs((workshop.getyPos() - car.getyPos())) < 70) {
            return true;
        }


        return false;
    }

    public void updateCarPositions() {
        for (Vehicle car : cars) {
            int x = (int) Math.round(car.getxPos());
            int y = (int) Math.round(car.getyPos());
            if ((0 > x || x > 700) || (0 > y || y > 500)) {
                car.turnLeft();
                car.turnLeft();
            }


            car.move();
            notifyObservers(car, false);
            // repaint() calls the paintComponent method of the panel


            for (Workshop workshop : workshops) {

                if (workshopCollisionCheck(car, workshop)) {
                    if (workshop.getType().isInstance(car) && !workshop.getSlotList().contains(car)) {
                        notifyObservers(car, workshopCollisionCheck(car, workshop));
                        workshop.loadCar(car);
                        continue;
                    }
                    car.turnLeft();
                    car.turnLeft();

                }
            }
        }
    }

    void notifyObservers(Vehicle car, Boolean collision) {
        for (Observer observer : observers) {
            observer.buttonPressed(car, collision);
        }
    }

}
