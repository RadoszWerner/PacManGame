package GameGUI;


import Engine.GameEngine;
import GameGUI.Panels.GamePanel;

import java.awt.*;

public class GameWindow extends Window {
    GamePanel gamePanel;
    public GameWindow(){
        super();
        initializeGamePanel();
        startGameEngine();

    }
    void startGameEngine(){
        GameEngine engine = new GameEngine(gamePanel);
        Thread gameThread = new Thread(engine);
        gameFrame.setVisible(true);
        gameThread.start();
    }
    void initializeGamePanel(){
        gamePanel =new GamePanel(gameFrame);
        gameFrame.getContentPane().add(gamePanel, BorderLayout.CENTER);
    }
}
