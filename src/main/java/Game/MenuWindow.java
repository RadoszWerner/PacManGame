package Game;

import Game.GameEngine;
import Game.GameWindow;
import Panels.GamePanel;
import Panels.MenuPanel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class MenuWindow extends GameWindow {
   @Getter @Setter
   GameEngine gameEngine;


    public MenuWindow(GameFrame gameFrame)  {
        super(gameFrame);
        MenuPanel menu = new MenuPanel(gameFrame);
        gameFrame.getContentPane().add(menu);
        gameFrame.setVisible(true);
    }

}
