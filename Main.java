import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main {

    // The delay (ms) corresponds to 20 updates a sec (hz)

    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.


    public static void main(String[] args) {
        // Instance of this class


        CarModel model = new CarModel();
        // The frame that represents this instance View of the MVC pattern
        CarView frame = new CarView("CarSim 1.0", model);
        CarController cc = new CarController(frame, model);
        cc.timer.start();



        // Start a new view and send a reference of self


        // Start the timer

    }

}




