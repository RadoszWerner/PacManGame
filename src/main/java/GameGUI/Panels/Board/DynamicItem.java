package GameGUI.Panels.Board;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;
import java.awt.event.KeyEvent;

public abstract class DynamicItem extends BoardItem {
    @Getter
    @Setter
    int delay;
    @Getter @Setter boolean isMoving;

    @Getter @Setter int plannedDirection;
    @Getter @Setter int direction;

    public DynamicItem(int x, int y, Color color, int speed) {
        super(x, y, color);
        delay = 1000/speed;
    }

    public void moveRight() {
        setX(getX()+1);
    }

    public void moveLeft() {
        setX(getX()-1);
    }

    public void moveUp() {
        setY(getY()-1);
    }

    public void moveBottom() {
        setY(getY()+1);
    }
     void makeMove(){
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
}
