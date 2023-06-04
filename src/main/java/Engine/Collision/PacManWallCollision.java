package Engine.Collision;

import GameGUI.Panels.Board.PacMan;
import GameGUI.Panels.Board.Wall;
import Utils.DirectionChecker;
import lombok.AllArgsConstructor;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

@AllArgsConstructor
public class PacManWallCollision implements Collision {
    PacMan pacMan;
    ArrayList<Wall> walls;

    boolean checkUpCollision(Wall wall){
        return DirectionChecker.checkUp(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY());
    }
    boolean checkDownCollision(Wall wall){
        return DirectionChecker.checkDown(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY());
    }
     boolean checkLeftCollision(Wall wall){
         return DirectionChecker.checkLeft(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY());
    }
     boolean checkRightCollision(Wall wall){
        return DirectionChecker.checkRight(pacMan.getX(),  pacMan.getY(), wall.getX(), wall.getY());
    }
    void stopMoving(){
        pacMan.setMoving(false);
    }
    void changeDirectionIfNoCollision(){
         pacMan.setDirection(pacMan.getPlannedDirection());
        pacMan.setMoving(true);
    }
    public void checkCollision(){
        boolean isWall = false;
        for (Wall wall:walls) {
            if(pacMan.getDirection() == KeyEvent.VK_LEFT && checkLeftCollision(wall)){
                stopMoving();
            }else if(pacMan.getDirection() == KeyEvent.VK_RIGHT && checkRightCollision(wall)){
                stopMoving();
            }else if(pacMan.getDirection() == KeyEvent.VK_UP && checkUpCollision(wall)){
                stopMoving();
            }else if(pacMan.getDirection() == KeyEvent.VK_DOWN && checkDownCollision(wall)){
                stopMoving();
            }
            if(pacMan.getPlannedDirection() == KeyEvent.VK_LEFT && checkLeftCollision(wall)){
                isWall = true;
            }else if(pacMan.getPlannedDirection() == KeyEvent.VK_RIGHT && checkRightCollision(wall)){
                isWall = true;
            }else if(pacMan.getPlannedDirection() == KeyEvent.VK_UP && checkUpCollision(wall)){
                isWall = true;
            }else if(pacMan.getPlannedDirection() == KeyEvent.VK_DOWN && checkDownCollision(wall)){
                isWall = true;
            }

        }
        if(!isWall) changeDirectionIfNoCollision();
    }
}
