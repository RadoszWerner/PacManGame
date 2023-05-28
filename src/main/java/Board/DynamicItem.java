package Board;

import java.awt.event.KeyEvent;

public interface DynamicItem {
    void moveRight();
    void moveLeft();
    void moveUp();
    void moveBottom();
    void makeMove();
}
