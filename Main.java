import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main {



    public static void main(String[] args) {

        CarModel model = new CarModel();

        CarView frame = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(frame, model);
        model.addCar();
        model.addCar();
        model.addCar();
        //workshops.add();






    }

}




