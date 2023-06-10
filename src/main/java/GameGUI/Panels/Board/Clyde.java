package GameGUI.Panels.Board;

import Utils.GameConstants;


public class Clyde extends Ghost{
    public Clyde(int x, int y) {
        super(x, y, GameConstants.CLYDE_COLOR);
    }
    public Clyde() {
        super(GameConstants.START_CLYDE_X, GameConstants.START_CLYDE_Y, GameConstants.CLYDE_COLOR);
    }
}
