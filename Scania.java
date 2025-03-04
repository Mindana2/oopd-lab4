import java.awt.*;

public class Scania extends Truck implements Tippable{

    private double tipperAngle;


    public Scania(double tipperAngle) {
        super(2, Color.red, 100.0, "Scania", 0d, 200d,"pics/Scania.jpg");
        stopEngine();
        this.tipperAngle = tipperAngle;

    }

    public double getTipperAngle() {
        return this.tipperAngle;
    }


    @Override
    public void adjustTipper(int angle){

        if (0 <= angle && angle <= 70 && this.getCurrentSpeed() == 0) {
            this.tipperAngle = angle;
            System.out.println("Tipper angle adjusted to " + angle);

        } else {
            System.out.println("Scania must be standing still to adjust tipper");
        }
        if (angle < 0) {
            this.tipperAngle = 0;
        }

        if (angle > 70) {
            this.tipperAngle = 70;
        }
    }



    @Override
    public void move() {
        if (this.tipperAngle == 0) {
            super.move();
        }
        else {

        }
        }
    }


