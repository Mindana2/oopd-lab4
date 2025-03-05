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
    Timer timer = new Timer(delay, new TimerListener());
    // The delay (ms) corresponds to 20 updates a sec (hz)
    int gasAmount = 0;
    int tipperAmount = 0;
    public CarController(CarView frame, CarModel model) {
        this.frame = frame;
        this.model = model;
    }
    private void InitButtons() {
            frame.gasSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
                });
            frame.tipperSpinner.addChangeListener(new ChangeListener() {
                public void stateChanged(ChangeEvent e) {
                    tipperAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
                });

            frame.startButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.startEngine();
                    model.notifyObservers(frame.startButton);
                }
            });

            frame.stopButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.stopEngine();
                    model.notifyObservers(frame.stopButton);
                }
            });

            frame.gasButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.gas(gasAmount);
                    model.notifyObservers(frame.gasButton);
                }
            });

            frame.brakeButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.brake(gasAmount);
                    model.notifyObservers(frame.brakeButton);
                }
            });

            frame.turboOnButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTurboOn();
                    model.notifyObservers(frame.turboOnButton);
                }
            });

            frame.turboOffButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.setTurboOff();
                    model.notifyObservers(frame.turboOffButton);
                }
            });
            frame.turnLeftButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.turnLeft();
                    model.notifyObservers(frame.turnLeftButton);
                }
            });
            frame.turnRightButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.turnRight();
                    model.notifyObservers(frame.turnRightButton);
                }
            });
            frame.adjustBedButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    model.adjustTipper(tipperAmount);
                    model.notifyObservers(frame.adjustBedButton);
                }
            });





    }
    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            for (Vehicle car : model.getCars()) {
                int x = (int) Math.round(car.getxPos());
                int y = (int) Math.round(car.getyPos());
                if ((0 > x || x > 700) || (0 > y || y > 500)) {
                    car.turnLeft();
                    car.turnLeft();
                }


                car.move();
                frame.drawPanel.moveit(car.getPath(), x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();

                for (Workshop workshop : model.getWorkshops()) {

                    if (model.workshopCollisionCheck(car, workshop)) {
                        if (workshop.getType().isInstance(car) && !workshop.getSlotList().contains(car)) {
                            frame.drawPanel.loadWorkshop(car);
                            workshop.loadCar(car);
                            continue;
                        }
                        car.turnLeft();
                        car.turnLeft();

                    }
                }
            }
        }
    }
        /* Each step the TimerListener moves all the cars in the list and tells the
         * view to update its images. Change this method to your needs.
         * */
}

    // Calls the gas method for each car once
