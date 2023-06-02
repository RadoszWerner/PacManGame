package Collision;

import Board.PacMan;
import Board.Wall;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PacManWallCollision implements Collision {
    ArrayList<Wall> walls;
    PacMan pacMan;

    public void checkUpCollision(Wall wall){
        if(pacMan.getX() == wall.getX() && pacMan.getY()-1 == wall.getY()){
            pacMan.setMoving(false);
        }
    }
    public void checkDownCollision(Wall wall){
        if(pacMan.getX() == wall.getX() && pacMan.getY()+1 == wall.getY()){
            pacMan.setMoving(false);
        }
    }
    public void checkLeftCollision(Wall wall){
        if(pacMan.getX()-1 == wall.getX() && pacMan.getY() == wall.getY()){
            pacMan.setMoving(false);
        }
    }
    public void checkRightCollision(Wall wall){
        if(pacMan.getX()+1 == wall.getX() && pacMan.getY() == wall.getY()){
            pacMan.setMoving(false);
        }
    }
    public void checkCollision(ArrayList<Wall> walls, PacMan pacMan){
        this.pacMan = pacMan;
        for (Wall wall:walls) {
            if(pacMan.getDirection() == KeyEvent.VK_LEFT){
                checkLeftCollision(wall);
            } else if(pacMan.getDirection() == KeyEvent.VK_RIGHT){
                checkRightCollision(wall);
            }else if(pacMan.getDirection() == KeyEvent.VK_UP){
                checkUpCollision(wall);
            }else if(pacMan.getDirection() == KeyEvent.VK_DOWN){
                checkDownCollision(wall);
            }
        }
    }
}
