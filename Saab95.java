import java.awt.*;

public class Saab95 extends Car {

    private boolean turboOn;

    public Saab95(boolean turboOn) {
        super(2, Color.red, 125.0, "Saab95", 0d, 100d, "pics/Saab95.jpg");
        this.turboOn = turboOn;
        stopEngine();
    }



    public void setTurboOn() {
        turboOn = true;
    }

    public void setTurboOff() {
        turboOn = false;
    }

    private double speedFactor() {
        double turbo = 1;
        if (turboOn) turbo = 1.3;
        return this.getEnginePower() * 0.01 * turbo;
    }


    @Override
    public void incrementSpeed(double amount) {

        if (this.getCurrentSpeed() + speedFactor() * amount >= this.getEnginePower()) {
            this.setCurrentSpeed(this.getEnginePower());
        } else {
            this.setCurrentSpeed(this.getCurrentSpeed() + speedFactor() * amount);
        }

    }

    @Override
    public void decrementSpeed(double amount){

            this.setCurrentSpeed(this.getCurrentSpeed() - speedFactor() * amount);
            if (this.getCurrentSpeed() < 0) {
                this.setCurrentSpeed(0);
            }
        }

}

