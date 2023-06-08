package GameGUI;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public class Window {
    @Getter
    public GameFrame gameFrame;
    public Window(){
        gameFrame = GameFrame.getInstance();
    }
}
