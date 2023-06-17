package GameGUI.Panels.Board;

import Utils.GameConstants;

import java.awt.*;

public class Ghost extends DynamicItem implements Runnable{
    public Ghost(int x, int y, Color color) {
        super(x, y, color, GameConstants.GHOST_SPEED);
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
}
