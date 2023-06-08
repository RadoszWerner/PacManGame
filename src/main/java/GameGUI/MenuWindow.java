package GameGUI;

import Engine.GameEngine;
import GameGUI.Panels.MenuPanel;
import lombok.Getter;
import lombok.Setter;

public class MenuWindow extends Window {
   @Getter @Setter
   GameEngine gameEngine;


    public MenuWindow()  {
        super();
        MenuPanel menu = new MenuPanel();
        gameFrame.getContentPane().add(menu);
        gameFrame.setVisible(true);
    }

}
