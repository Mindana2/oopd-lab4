import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.attribute.FileOwnerAttributeView;

/**
 * This class represents the full view of the MVC pattern of your car simulator.
 * It initializes with being center on the screen and attaching it's controller in it's state.
 * It communicates with the Controller by calling methods of it when an action fires of in
 * each of it's components.
 * TODO: Write more actionListeners and wire the rest of the buttons
 **/

public class CarView extends JFrame implements Observer{
    private static final int X = 800;
    private static final int Y = 800;

    // The controller member

    DrawPanel drawPanel = new DrawPanel(X, Y-240);

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    JSpinner tipperSpinner = new JSpinner();

    JLabel gasLabel = new JLabel("Amount of gas");
    JLabel tipperLabel = new JLabel("Tipper angle");



    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Turbo on");
    JButton turboOffButton = new JButton("Turbo off");
    JButton adjustBedButton = new JButton("Adjust Bed");
    JButton turnRightButton = new JButton("Turn Right");
    JButton turnLeftButton = new JButton("Turn Left");
    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");
    JButton addCarButton = new JButton("Add car");
    JButton removeCarButton = new JButton("Remove car");

    // Constructor
    public CarView(String framename, CarModel model){
        model.addObserver(this);
        initComponents(framename);
    }

    // Sets everything in place and fits everything
    // TODO: Take a good look and make sure you understand how these methods and components work
    private void initComponents(String title) {

        this.setTitle(title);
        this.setPreferredSize(new Dimension(X,Y));
        this.setLayout(new FlowLayout(FlowLayout.LEFT, 0, 0));

        this.add(drawPanel);



        SpinnerModel gasspinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        100, //max
                        1);//step

        SpinnerModel tipspinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        70, //max
                        1);//step
        gasSpinner = new JSpinner(gasspinnerModel);
        tipperSpinner = new JSpinner(tipspinnerModel);

        gasPanel.setLayout(new FlowLayout());
        gasPanel.setPreferredSize(new Dimension(100, 100));

        gasPanel.add(gasLabel);
        gasPanel.add(gasSpinner);

        gasPanel.add(tipperLabel);
        gasPanel.add(tipperSpinner);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,6));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(adjustBedButton, 2);
        controlPanel.add(turnRightButton, 3);
        controlPanel.add(brakeButton, 4);
        controlPanel.add(turboOffButton, 5);
        controlPanel.add(turnLeftButton, 6);
        controlPanel.add(addCarButton, 7);
        controlPanel.add(removeCarButton, 8);
        controlPanel.setPreferredSize(new Dimension((X/2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(X/6-15,200));
        this.add(stopButton);


        // Make the frame pack all it's components by respecting the sizes if possible.
        this.pack();

        // Get the computer screen resolution
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        // Center the frame
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        // Make the frame visible
        this.setVisible(true);
        // Make sure the frame exits when "x" is pressed
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void buttonPressed(Vehicle car, Boolean collision) {
        if (collision) {
            drawPanel.loadWorkshop(car);
        }
        int x = (int) Math.round(car.getxPos());
        int y = (int) Math.round(car.getyPos());
        drawPanel.moveit(car.getPath(), x, y);
        drawPanel.repaint();
    }
}