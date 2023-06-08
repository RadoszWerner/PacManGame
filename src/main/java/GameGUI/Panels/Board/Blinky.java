package GameGUI.Panels.Board;

import Utils.GameConstants;

import java.awt.*;

public class Blinky extends Ghost{
    public Blinky(int x, int y) {
        super(x, y, GameConstants.BLINKY_COLOR);
    }
    public Blinky() {
        super(GameConstants.START_BLINKY_X, GameConstants.START_BLINKY_Y, GameConstants.BLINKY_COLOR);
    }
}
