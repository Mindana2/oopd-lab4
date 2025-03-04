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
    

    public DrawPanel(int x, int y) {


        Image volvo = new Image(0, 0, true, "pics/Volvo240.jpg");
        Image scania = new Image(0, 100, true, "pics/Scania.jpg");
        Image saab = new Image(0, 200, true, "pics/Saab95.jpg");
        Image volvoworkshop = new Image(300, 300 ,true, "pics/VolvoBrand.jpg");

        model.ImageList.add(volvo);
        model.ImageList.add(saab);
        model.ImageList.add(scania);
        model.ImageList.add(volvoworkshop);

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

        for (Image image : model.ImageList){
            if (Objects.equals(path, image.getPath())){
                image.setxPos(x);
                image.setyPos(y);
            }
        }
    }
    void loadWorkshop(Vehicle car){

        for (Image image : model.ImageList){
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


        for (Image image : model.ImageList) {
            if (image.getVisibility()) {
                g.drawImage(loadImage(image.getPath()), image.getxPos(), image.getyPos(), null);
            }
        }


    }
}
