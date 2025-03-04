import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Vehicle implements Movable {

    private final int nrDoors; // Number of doors on the car
    private final double enginePower; // Engine power of the car
    private double currentSpeed; // The current speed of the car
    private Color color; // Color of the car
    private final String modelName;
    private double xPos;
    private double yPos;
    private final String imagePath;


    private final List<String> dirs = Arrays.asList("up", "right", "down", "left");

    private int dirsIndex;

    public Vehicle(int nrDoors, Color color, Double enginePower, String modelName, Double xPos, Double yPos, String imagePath) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xPos = xPos;
        this.yPos = yPos;
        this.dirsIndex = 0;
        this.imagePath = imagePath;


        stopEngine();
    }
    public String getPath(){ return this.imagePath; }
    public String getModelName() {
        return this.modelName;
    }

    public double getEnginePower() {
        return this.enginePower;
    }

    public double getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(double amount) {this.currentSpeed = amount;}

    public void startEngine() {
        this.currentSpeed = 0.1;
    }

    public void stopEngine() {
        this.currentSpeed = 0;
    }

    public String getDirection() {
        return dirs.get((((this.dirsIndex % 4) + 4) % 4));
    }

    public double getxPos() {
        return this.xPos;
    }

    public double getyPos() {
        return this.yPos;
    }

    public void setxPos(double pos) {
        this.xPos = pos;
    }

    public void setyPos(double pos) {
        this.yPos = pos;
    }




    public void move() {

        String direction = this.getDirection();

        if (Objects.equals(direction, "up")) {
            //if direction == "up"
            this.yPos += this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "right")) {
            this.xPos += this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "down")) {
            this.yPos -= this.getCurrentSpeed();
        }

        if (Objects.equals(direction, "left")) {
            this.xPos -= this.getCurrentSpeed();
        }


    }

    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + 1 * amount, this.getEnginePower()));
        if (this.getCurrentSpeed() > this.getEnginePower()) {
            this.setCurrentSpeed(this.getEnginePower());
        }
    }

    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() -1 * amount, 0));
        if (this.getCurrentSpeed() < 0) {
            this.setCurrentSpeed(0);
        }
    }
    public void turnLeft() {
        this.dirsIndex -= 1;
    }

    public void turnRight() {
        this.dirsIndex += 1;
    }

    public void gas(double amount){

        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }

        if (amount < 0) {
            incrementSpeed(0);
        }

        if (amount > 1) {
            incrementSpeed(1);
        }

    }

    public void brake(double amount) {

        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
        if (amount < 0 ){
            decrementSpeed(0);

        }
        if (amount > 1) {
            decrementSpeed(1);
        }
    }
}



