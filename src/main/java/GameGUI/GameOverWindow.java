package GameGUI;

import GameGUI.Buttons.MenuButton;
import GameGUI.Panels.GameOverPanel;

import javax.swing.*;
import java.awt.*;

public class GameOverWindow extends Window {
    JPanel centralPanel;
    public GameOverWindow(){
        super();
        initializeGameOver();
    }
    void initializeGameOver(){
        GameOverPanel panel = new GameOverPanel();
        gameFrame.getContentPane().add(panel);
        gameFrame.setVisible(true);
    }


}
