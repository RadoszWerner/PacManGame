package Engine.Collision;

import GameGUI.Panels.Board.DynamicItem;
import GameGUI.Panels.Board.Wall;
import Utils.DirectionChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

@AllArgsConstructor
public class DynamicItemWallCollision implements Collision {
    DynamicItem dynamicItem;
    ArrayList<Wall> walls;
    @Getter @Setter boolean rightCollision;
    @Getter @Setter boolean leftCollision;
    @Getter @Setter boolean upCollision;
    @Getter @Setter boolean downCollision;
    @Getter @Setter boolean leftWall;
    @Getter @Setter boolean rightWall;
    @Getter @Setter boolean upWall;
    @Getter @Setter boolean downWall;
    public DynamicItemWallCollision( DynamicItem dynamicItem, ArrayList<Wall> walls){
        this.dynamicItem = dynamicItem;
        this.walls = walls;
    }

    public boolean checkUpCollision(Wall wall){
        return DirectionChecker.checkUp(dynamicItem.getX(),  dynamicItem.getY(), wall.getX(), wall.getY());
    }
    public boolean checkDownCollision(Wall wall){
        return DirectionChecker.checkDown(dynamicItem.getX(),  dynamicItem.getY(), wall.getX(), wall.getY());
    }
    public boolean checkLeftCollision(Wall wall){
         return DirectionChecker.checkLeft(dynamicItem.getX(),  dynamicItem.getY(), wall.getX(), wall.getY());
    }
    public boolean checkRightCollision(Wall wall){
        return DirectionChecker.checkRight(dynamicItem.getX(),  dynamicItem.getY(), wall.getX(), wall.getY());
    }
    void stopMoving(){
        dynamicItem.setMoving(false);
    }
    void changeDirectionIfNoCollision(){
         dynamicItem.setDirection(dynamicItem.getPlannedDirection());
        dynamicItem.setMoving(true);
    }
    public void checkCollision(){
        boolean isWall = false;
        leftWall = false;rightWall = false;downWall = false;upWall = false;
        for (Wall wall:walls) {
            leftCollision = checkLeftCollision(wall);
            rightCollision = checkRightCollision(wall);
            upCollision = checkUpCollision(wall);
            downCollision = checkDownCollision(wall);
            if(dynamicItem.getDirection() == KeyEvent.VK_LEFT && leftCollision){
                stopMoving();
            }else if(dynamicItem.getDirection() == KeyEvent.VK_RIGHT && rightCollision){
                stopMoving();
            }else if(dynamicItem.getDirection() == KeyEvent.VK_UP && upCollision){
                stopMoving();
            }else if(dynamicItem.getDirection() == KeyEvent.VK_DOWN && downCollision){
                stopMoving();
            }
            if(dynamicItem.getPlannedDirection() == KeyEvent.VK_LEFT && leftCollision){
                leftWall = true;
                isWall = true;
            }else if(dynamicItem.getPlannedDirection() == KeyEvent.VK_RIGHT && rightCollision){
                rightWall = true;
                isWall = true;
            }else if(dynamicItem.getPlannedDirection() == KeyEvent.VK_UP && upCollision){
                upWall = true;
                isWall = true;
            }else if(dynamicItem.getPlannedDirection() == KeyEvent.VK_DOWN && downCollision){
                downWall = true;
                isWall = true;
            }

        }
        if(!isWall) changeDirectionIfNoCollision();
    }
}
