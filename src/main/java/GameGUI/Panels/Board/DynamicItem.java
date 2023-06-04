package GameGUI.Panels.Board;

import lombok.Getter;
import lombok.Setter;

import java.awt.*;

public abstract class DynamicItem extends BoardItem {
    @Getter
    @Setter
    int delay;

    public DynamicItem(int x, int y, Color color, int speed) {
        super(x, y, color);
        delay = 1000/speed;
    }

    public void moveRight() {
        setX(getX()+1);
    }

    public void moveLeft() {
        setX(getX()-1);
    }

    public void moveUp() {
        setY(getY()-1);
    }

    public void moveBottom() {
        setY(getY()+1);
    }
    abstract void makeMove();
}
