package Collision;

import Board.BoardItem;
import Board.PacMan;
import Board.Wall;
import Utils.DirectionChecker;
import lombok.AllArgsConstructor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

@AllArgsConstructor
public class PacManWallCollision implements Collision {
    PacMan pacMan;
    ArrayList<Wall> walls;

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
    public void checkCollision(){
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
