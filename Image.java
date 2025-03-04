
public class Image {


    private int xPos, yPos;
    private boolean isVisible;
    private final String imagePath;




    public Image(int xPos, int yPos, boolean isVisible, String imagePath)  {


        this.xPos = xPos;
        this.yPos = yPos;
        this.isVisible = isVisible;
        this.imagePath = imagePath;

    }


    public int getxPos() {
        return this.xPos;
    }

    public int getyPos() {
        return this.yPos;
    }

    public  String getPath(){return this.imagePath;}

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }


    public boolean getVisibility(){
        return this.isVisible;
    }

    public void setVisibility(boolean state){
        this.isVisible = state;
    }




}
