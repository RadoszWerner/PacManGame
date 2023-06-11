package Engine.AI;

import Engine.Collision.DynamicItemWallCollision;
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
        if(!moreHorizontal){
            if(pacmanY > blinkyY  && blinky.isMoving()){
                blinky.setPlannedDirection(KeyEvent.VK_DOWN);
            } else if (pacmanY < blinkyY  && blinky.isMoving() ){
                blinky.setPlannedDirection(KeyEvent.VK_UP);
            } else{
                if (pacmanX < blinkyX && blinky.isMoving() ){
                    blinky.setPlannedDirection(KeyEvent.VK_LEFT);
                }else if (pacmanX > blinkyX  && blinky.isMoving()){
                    blinky.setPlannedDirection(KeyEvent.VK_RIGHT);
                } else{
                    Random random = new Random();
                    int randomNumber = random.nextInt(4) + 37;
                    blinky.setPlannedDirection(randomNumber);

                }
            }
        }else{
            if (pacmanX < blinkyX && blinky.isMoving() ){
                blinky.setPlannedDirection(KeyEvent.VK_LEFT);
            }else if (pacmanX > blinkyX  && blinky.isMoving()){
                blinky.setPlannedDirection(KeyEvent.VK_RIGHT);
            } else{
                if(pacmanY > blinkyY  && blinky.isMoving()){
                    blinky.setPlannedDirection(KeyEvent.VK_DOWN);
                } else if (pacmanY < blinkyY  && blinky.isMoving() ){
                    blinky.setPlannedDirection(KeyEvent.VK_UP);
                }else{
                    Random random = new Random();
                    int randomNumber = random.nextInt(4) + 37;
                    blinky.setPlannedDirection(randomNumber);

                }
            }
        }


    }
}
