import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* Its responsibilities are to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    CarView frame;
    CarModel model;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.


    // The delay (ms) corresponds to 20 updates a sec (hz)

    public CarController(CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
    }
    private void Buttons() {
        for (Observer observer : this.model.getObservers()) {
            frame.startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.startEngine();
                }
            });

            frame.stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.stopEngine();
                }
            });

            frame.gasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.gas(frame.gasAmount);
                }
            });

            frame.brakeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.brake(frame.gasAmount);
                }
            });

            frame.turboOnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTurboOn();
                }
            });

            frame.turboOffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTurboOff();
                }
            });
            frame.turnLeftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.turnLeft();
                }
            });
            frame.turnRightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.turnRight();
                }
            });
            frame.adjustBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.adjustTipper(frame.tipperAmount);
                }
            });


//methods:


        }

        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
    }

    // Calls the gas method for each car once
}