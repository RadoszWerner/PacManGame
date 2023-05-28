package Board;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BoardItem {
     int x;
     int y;
    Color color;
    ImageIcon image = null;


    public int getLayer(){
        return 1;
    }

    public BoardItem(int x, int y, String pathName) {
        this.x = x;
        this.y = y;
        image = new ImageIcon("assets/"+pathName+ ".png");
    }
    public BoardItem(int x, int y, Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }



    public ImageIcon getImage() {
        return image;
    }
}
