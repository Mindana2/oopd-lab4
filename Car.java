import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public abstract class Car extends Vehicle {

    public Car(int nrDoors, Color color, Double enginePower, String modelName, Double xPos, Double yPos, String path) {
        super(nrDoors, color, enginePower, modelName, xPos, yPos, path);

    }

}