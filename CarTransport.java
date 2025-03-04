import java.awt.*;
import java.util.Arrays;
import java.util.List;

public class CarTransport extends Truck implements Loadable, Tippable{

    private boolean rampDown;
    private Vehicle[] slotList;
    private int numSlots;


    public CarTransport(boolean rampDown, int numSlots) {
        super(2, Color.black, 100.0, "Car Transport", 0d, 0d, null);
        stopEngine();
        this.rampDown = rampDown;
        this.slotList = new Car[numSlots];

    }

    public int getNumSlots(){
        return this.numSlots;
    }

    public Vehicle[] getSlotList(){
        return this.slotList;
    }

    public boolean getTipperState(){return this.rampDown;}



    public void adjustTipper(int angle) {

        if ((this.getCurrentSpeed() == 0) && (angle == 0)) {
            this.rampDown = false;
        }

        if (this.getCurrentSpeed() == 0 && (angle == 70)) {
            this.rampDown = true;
        }


        else {
            System.out.println("Car Transport tipper angle must be 0 or 70");
        }


    }



    @Override
    public void move() {
        if (!this.rampDown) {
            super.move();

            for (int i = 0; i < this.slotList.length; i++) {
                if (this.slotList[i] != null) {
                    this.slotList[i].setxPos(this.getxPos());
                    this.slotList[i].setyPos(this.getyPos());
                }
            }
        }


    }

    public void loadCar(Car car){

        if (Math.abs(car.getxPos() - this.getxPos()) >= 1 || Math.abs(car.getyPos() - this.getyPos()) >= 1){
            System.out.println("Car is too far");
        }

        if (this.rampDown && Math.abs(car.getxPos() - this.getxPos()) < 1 && Math.abs(car.getyPos() - this.getyPos()) < 1){
            for (int i = 0; i < this.slotList.length; i++){
                if (this.slotList[i] == null){
                    this.slotList[i] = car;
                    System.out.println(car + " loaded");
                    return;

                }

            }



        System.out.println("Car Transport is full");
        }


    }

    public void unloadCar(){
        if (this.rampDown){
            for (int i = this.slotList.length-1; i >= 0; i--){
                if (this.slotList[i] != null){
                    this.slotList[i].setyPos(this.slotList[i].getyPos()-1);
                    this.slotList[i] = null;

                    System.out.println("unloaded");
                    return;

                }
            }

            System.out.println("Car Transport is empty");
        }



    }

}
