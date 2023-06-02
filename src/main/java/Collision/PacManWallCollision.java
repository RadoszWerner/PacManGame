package Collision;

import Board.PacMan;
import Board.Wall;
import Utils.DirectionChecker;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PacManWallCollision implements Collision {
    ArrayList<Wall> walls;
    PacMan pacMan;

    public void checkUpCollision(Wall wall){
        if(DirectionChecker.checkUp(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY())){
            pacMan.setMoving(false);
        }
    }
    public void checkDownCollision(Wall wall){
        if(DirectionChecker.checkDown(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY())){
            pacMan.setMoving(false);
        }
    }
    public void checkLeftCollision(Wall wall){
        if(DirectionChecker.checkLeft(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY())){
            pacMan.setMoving(false);
        }
    }
    public void checkRightCollision(Wall wall){
        if(DirectionChecker.checkRight(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY())){
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
