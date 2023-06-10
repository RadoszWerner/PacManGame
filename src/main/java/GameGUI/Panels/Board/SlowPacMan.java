package GameGUI.Panels.Board;

import Utils.GameConstants;

public class SlowPacMan extends PacMan {
    public SlowPacMan(int x, int y) {
        super(x, y, GameConstants.PACMAN_COLOR, GameConstants.SLOW_PACMAN_SPEED);
    }
    public SlowPacMan() {
        super(GameConstants.START_PACMAN_X, GameConstants.START_PACMAN_Y, GameConstants.PACMAN_COLOR, GameConstants.SLOW_PACMAN_SPEED);
    }

}
