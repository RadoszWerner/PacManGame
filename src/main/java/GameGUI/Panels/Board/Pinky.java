package GameGUI.Panels.Board;

import Utils.GameConstants;


public class Pinky extends Ghost{
    public Pinky(int x, int y) {
        super(x, y, GameConstants.PINKY_COLOR);
    }
    public Pinky() {
        super(GameConstants.START_PINKY_X, GameConstants.START_PINKY_Y, GameConstants.PINKY_COLOR);
    }
}
