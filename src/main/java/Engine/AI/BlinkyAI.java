package Engine.AI;

import Engine.Collision.DynamicItemWallCollision;
import GameGUI.Panels.Board.Blinky;
import GameGUI.Panels.Board.Ghost;
import GameGUI.Panels.Board.PacMan;
import lombok.AllArgsConstructor;

import java.awt.event.KeyEvent;
import java.util.Random;

@AllArgsConstructor
public class BlinkyAI implements AI{
    PacMan pacman;
    Ghost blinky;
    DynamicItemWallCollision collision;
    @Override
    public void setDirection() {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();
        int blinkyX = blinky.getX();
        int blinkyY = blinky.getY();
        boolean moreHorizontal = Math.abs(pacmanY - blinkyY) < Math.abs(pacmanX - blinkyX);
        int vertical, horizontal;
        if(pacmanX < blinkyX) horizontal = KeyEvent.VK_LEFT;
        else horizontal = KeyEvent.VK_RIGHT;
        if(pacmanY > blinkyY) vertical = KeyEvent.VK_DOWN;
        else vertical = KeyEvent.VK_UP;
        if(pacmanY > blinkyY && !moreHorizontal){
            if(!collision.isUpWall())  blinky.setPlannedDirection(vertical);
            else blinky.setPlannedDirection(horizontal);
        } if (pacmanY < blinkyY && !moreHorizontal  ){
            if(!collision.isDownWall())  blinky.setPlannedDirection(vertical);
            else blinky.setPlannedDirection(horizontal);
        }if (pacmanX < blinkyX && moreHorizontal){
            if(!collision.isLeftWall())  blinky.setPlannedDirection(horizontal);
            else blinky.setPlannedDirection(vertical);
        }if (pacmanX > blinkyX && moreHorizontal  ){
            if(!collision.isRightWall())  blinky.setPlannedDirection(horizontal);
            else blinky.setPlannedDirection(vertical);
        }

    }
}
