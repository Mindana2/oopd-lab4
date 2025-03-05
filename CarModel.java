import javax.swing.*;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class CarModel {
   private ArrayList<Workshop> workshops = new ArrayList<>();
   private ArrayList<Vehicle> cars = new ArrayList<>();
   private static ArrayList<Observer> observers = new ArrayList<>();





    public CarModel(){

        cars.add(new Volvo240());
        cars.add(new Saab95(false));
        cars.add(new Scania(0));
        workshops.add(new Workshop<Volvo240>(5, 300, 300, Volvo240.class));
    }
    public void addObserver(Observer observer) {observers.add(observer);}

    public ArrayList<Observer> getObservers(){
        return observers;
    }

    public ArrayList<Vehicle> getCars() {
        return cars;
    }
    public ArrayList<Workshop> getWorkshops() {
        return workshops;
    }

    public void addCar(Vehicle car) {
        if (cars.size() < 10){
            cars.add(car);
        }
    }
    public void removeCar(Vehicle car){
        if (cars.isEmpty()){
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
    void notifyObservers(JButton button){
        for (Observer observer : observers) {
            observer.buttonPressed(button);
        }
    }


}

