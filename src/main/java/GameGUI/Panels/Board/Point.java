package GameGUI.Panels.Board;

import Utils.GameConstants;


public class Point extends BoardItem{
    public Point(int x, int y) {
        super(x, y, GameConstants.POINT_COLOR);
    }
}
