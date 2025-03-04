import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;
import javax.imageio.ImageIO;
import javax.swing.*;


// This panel represents the animated part of the view with the car images.

public class DrawPanel extends JPanel {

    // Just a single image, TODO: Generalize
    CarModel model;
    ArrayList<Image> ImageList = new ArrayList<>();

    public DrawPanel(int x, int y) {


        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.lightGray);
    }


    public BufferedImage loadImage(String path) {

        try {
            return ImageIO.read(Objects.requireNonNull(DrawPanel.class.getResourceAsStream(path)));

        } catch (IOException ex) {
            System.out.println("error");
            ex.printStackTrace();
        }
        return null;
    }






    // To keep track of a single car's position

    // TODO: Make this general for all cars
    void moveit(String path, int x, int y) {

        for (Image image : ImageList){
            if (Objects.equals(path, image.getPath())){
                image.setxPos(x);
                image.setyPos(y);
            }
        }
    }
    void loadWorkshop(Vehicle car){

        for (Image image : ImageList){
            if (Objects.equals(car.getPath(), image.getPath())) {
                image.setVisibility(false);
            }
        }

    }


    // Initializes the panel and reads the images


    // This method is called each time the panel updates/refreshes/repaints itself
    // TODO: Change to suit your needs.
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);


        for (Image image : ImageList) {
            if (image.getVisibility()) {
                g.drawImage(loadImage(image.getPath()), image.getxPos(), image.getyPos(), null);
            }
        }


    }
}
