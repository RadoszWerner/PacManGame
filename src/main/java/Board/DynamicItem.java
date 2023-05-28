package Board;

import java.awt.event.KeyEvent;

public interface DynamicItem {
    public abstract void moveRight();
    public abstract void moveLeft();
    public abstract void moveUp();
    public abstract void moveBottom();
    public abstract void makeMove();
}
