package Board;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class PacMan extends BoardItem implements DynamicItem, Runnable{
    private int speed;
    boolean isMoving;

    int direction;

    public int getDirection() {
        return direction;
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public PacMan(int x, int y, Color color) {
        super(x, y, color);
    }


    @Override
    public void moveRight() {

        setX(getX()+1);
    }

    @Override
    public void moveLeft() {
        setX(getX()-1);
    }

    @Override
    public void moveUp() {
        setY(getY()-1);
    }

    @Override
    public void moveBottom() {
        setY(getY()+1);
    }

    @Override
    public void makeMove() {
        isMoving = true;
                if(direction == KeyEvent.VK_RIGHT){
                    moveRight();
                }
                else if(direction == KeyEvent.VK_LEFT){
                    moveLeft();
                }
                else if(direction == KeyEvent.VK_UP){
                    moveUp();
                }
                else if(direction == KeyEvent.VK_DOWN){
                    moveBottom();
                } else{
                    isMoving = false;
                }







    }

    @Override
    public void run() {
        while (true){
            if(isMoving){
                makeMove();

            }
            try {
                Thread.sleep(1000/30 ); // Opóźnienie 60 FPS
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
