package GameGUI.Panels.Board;

import Utils.GameConstants;

public class Inky extends Ghost{
    public Inky(int x, int y) {
        super(x, y, GameConstants.INKY_COLOR);
    }
    public Inky() {
        super(GameConstants.START_INKY_X, GameConstants.START_INKY_Y, GameConstants.INKY_COLOR);
    }
}
