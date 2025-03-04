import java.awt.*;

public class Volvo240 extends Car {
    private final static double trimFactor = 1.25;

    public Volvo240() {
        super(4, Color.black, 100.0, "Volvo240", 0d, 0d, "pics/Volvo240.jpg");
        stopEngine();


    }


    private double speedFactor() {
        return this.getEnginePower() * 0.01 * trimFactor;
    }




    @Override
    public void incrementSpeed(double amount) {
        this.setCurrentSpeed(Math.min(getCurrentSpeed() + speedFactor() * amount, this.getEnginePower()));
        if (this.getCurrentSpeed() > this.getEnginePower()) {
            this.setCurrentSpeed(this.getEnginePower());
        }
    }

    @Override
    public void decrementSpeed(double amount) {
        this.setCurrentSpeed(Math.max(getCurrentSpeed() - speedFactor() * amount, 0));
        if (this.getCurrentSpeed() < 0) {
            this.setCurrentSpeed(0);
        }
    }


}
