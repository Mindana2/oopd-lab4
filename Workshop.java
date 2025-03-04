import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Workshop<T>{

    private final int numSlots;
    private ArrayList<T> slotList;
    private int xPos;
    private int yPos;
    private Class<T> type;


    public Workshop(int numSlots, int xPos, int yPos, Class<T> type) {
        this.slotList = new ArrayList<>(numSlots);
        this.numSlots = numSlots;
        this.xPos = xPos;
        this.yPos = yPos;
        this.type = type;




    }


    public int getNumSlots() {
        return this.numSlots;
    }

    public int getxPos(){ return this.xPos;}

    public int getyPos(){ return this.yPos;}

    public Class<T> getType(){ return this.type;}

    public ArrayList<T> getSlotList() {
        return this.slotList;
    }


    public void loadCar(T car) {
        if (this.slotList.size() != numSlots) {
            this.slotList.add(car);
            System.out.println(car + " loaded");
            return;

        }
        System.out.println("Workshop is full");
    }


    public void unloadCar(T car) {

        if (this.slotList.contains(car)) {
            System.out.println(car + " of type " + car.getClass() +  " unloaded");
            this.slotList.remove(car);
            return;
        }

        System.out.println(car + " is not in workshop");




    }
}

