import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Main {

    // The frame that represents this instance View of the MVC pattern
    private static CarView frame;
    private static CarModel model;
    private static CarController cc;
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private static final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private static Timer timer;


    public static void main(String[] args) {
        // Instance of this class
        timer = new Timer(delay, new TimerListener());
        // A list of cars, modify if needed

        frame = new CarView("CarSim 1.0");
        model = new CarModel(frame);
        cc = new CarController(frame, model);

        Image volvo = new Image(0, 0, true, "pics/Volvo240.jpg");
        Image scania = new Image(0, 100, true, "pics/Scania.jpg");
        Image saab = new Image(0, 200, true, "pics/Saab95.jpg");
        Image volvoworkshop = new Image(300, 300 ,true, "pics/VolvoBrand.jpg");


        model.addObserver(frame);
        frame.drawPanel.ImageList.add(volvo);
        frame.drawPanel.ImageList.add(scania);
        frame.drawPanel.ImageList.add(volvoworkshop);
        frame.drawPanel.ImageList.add(saab);
        model.workshops.add(new Workshop<Volvo240>(5, 300, 300, Volvo240.class));

        // Start a new view and send a reference of self


        // Start the timer
        timer.start();
    }
    private static class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {


            for (Vehicle car : model.cars) {
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

                for (Workshop workshop : model.workshops) {

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
}




