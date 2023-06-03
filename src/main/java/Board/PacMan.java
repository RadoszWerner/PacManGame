package Board;

import java.awt.*;
import java.awt.event.KeyEvent;


import lombok.Getter;
import lombok.Setter;

public class PacMan extends DynamicItem implements Runnable{
    @Getter @Setter boolean isMoving;
    @Getter @Setter boolean canMove;
    @Getter @Setter int direction;
    @Getter @Setter int plannedDirection;
    public PacMan(int x, int y, Color color, int speed) {
        super(x, y, color, speed);
    }

    @Override
    public void makeMove() {
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
