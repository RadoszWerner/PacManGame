package GameGUI.Panels.Board;
import Utils.GameConstants;

import java.awt.*;
public class Wall extends BoardItem{
    public Wall(int x, int y) {
        super(x, y, GameConstants.WALL_COLOR);
    }
}
