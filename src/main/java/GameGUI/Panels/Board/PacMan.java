package GameGUI.Panels.Board;

import java.awt.*;


import Utils.GameConstants;
import lombok.Getter;
import lombok.Setter;

public class PacMan extends DynamicItem implements Runnable{

    @Getter @Setter int lives;
    public PacMan(int x, int y, Color color, int speed) {
        super(x, y, color, speed);
        lives=3;
    }


    @Override
    public void run() {
        while (true){
            if(isMoving){
                makeMove();
            }
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void die() {
        lives--;
        x= GameConstants.START_PACMAN_X;
        y=GameConstants.START_PACMAN_Y;
        isMoving=false;
        direction=0;
        plannedDirection=0;
    }
}
