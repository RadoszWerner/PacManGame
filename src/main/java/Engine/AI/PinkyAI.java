package Engine.AI;

import Engine.Collision.DynamicItemWallCollision;
import GameGUI.Panels.Board.Ghost;
import GameGUI.Panels.Board.PacMan;
import lombok.AllArgsConstructor;

import java.awt.event.KeyEvent;

@AllArgsConstructor
public class PinkyAI implements AI{
    PacMan pacman;
    Ghost pinky;
    DynamicItemWallCollision collision;
    @Override
    public void setDirection() {
        int pacmanX = pacman.getX();
        int pacmanY = pacman.getY();
        int pinkyX = pinky.getX();
        int pinkyY = pinky.getY();
        boolean moreHorizontal = Math.abs(pacmanY - pinkyY) < Math.abs(pacmanX - pinkyX);
        if(pacmanY > pinkyY && !moreHorizontal){
            pinky.setPlannedDirection(KeyEvent.VK_DOWN);
        } else if (pacmanY < pinkyY && !moreHorizontal ){
            pinky.setPlannedDirection(KeyEvent.VK_UP);
        }else if (pacmanX < pinkyX && moreHorizontal ){
            pinky.setPlannedDirection(KeyEvent.VK_LEFT);
        }else if (pacmanX > pinkyX && moreHorizontal){
            pinky.setPlannedDirection(KeyEvent.VK_RIGHT);
        }

    }
}
