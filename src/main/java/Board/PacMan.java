package Board;

import java.awt.*;
import java.awt.event.KeyEvent;


import lombok.Getter;
import lombok.Setter;

public class PacMan extends BoardItem implements DynamicItem, Runnable{
    @Getter @Setter int delay;
    @Getter @Setter boolean isMoving;
    @Getter @Setter int direction;
    public PacMan(int x, int y, Color color, int speed) {
        super(x, y, color);
        delay = 1000/speed;
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
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}
