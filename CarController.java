import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
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
    static CarView frame;
    static CarModel model;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private static final int delay = 50;
    Timer timer;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    int gasAmount = 0;
    int tipperAmount = 0;

    public CarController(CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
        timer = new Timer(delay, new TimerListener());
        timer.start();
        InitButtons();
    }

    private void InitButtons() {
        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });
        frame.tipperSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                tipperAmount = (int) ((JSpinner) e.getSource()).getValue();
            }
        });

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
                model.gas(gasAmount);

            }
        });

        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(gasAmount);

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
                model.adjustTipper(tipperAmount);

            }
        });

        frame.addCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.addCar();

            }
        });

        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.removeCar();

            }
        });


    }

    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            model.updateCarPositions();

        }
        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
    }
}
    // Calls the gas method for each car once
