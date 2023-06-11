package Engine.AI;

import Engine.Collision.DynamicItemWallCollision;
import GameGUI.Panels.Board.Blinky;
import GameGUI.Panels.Board.PacMan;
import lombok.AllArgsConstructor;

import java.awt.event.KeyEvent;

@AllArgsConstructor
public class BlinkyAI implements AI{
    PacMan pacman;
    Blinky blinky;
    DynamicItemWallCollision collision;
    @Override
    public void setDirection() {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();
        int blinkyX = blinky.getX();
        int blinkyY = blinky.getY();
        boolean moreHorizontal = Math.abs(pacmanY - blinkyY) < Math.abs(pacmanX - blinkyX);
        if(pacmanY > blinkyY && !moreHorizontal && blinky.isMoving()){
            blinky.setPlannedDirection(KeyEvent.VK_DOWN);
        } else if (pacmanY < blinkyY && !moreHorizontal && blinky.isMoving()){
            blinky.setPlannedDirection(KeyEvent.VK_UP);
        }else if (pacmanX < blinkyX && moreHorizontal && blinky.isMoving()){
            blinky.setPlannedDirection(KeyEvent.VK_LEFT);
        }else if (pacmanX > blinkyX && moreHorizontal && blinky.isMoving()){
            blinky.setPlannedDirection(KeyEvent.VK_RIGHT);
        } else{
            blinky.setPlannedDirection(KeyEvent.VK_DOWN);
        }

    }
}
