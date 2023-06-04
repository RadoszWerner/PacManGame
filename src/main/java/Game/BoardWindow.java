package Game;


import Panels.GamePanel;

import javax.swing.*;
import java.awt.*;

public class BoardWindow extends GameWindow {
    GamePanel gamePanel;
    public BoardWindow(GameFrame gameFrame){
        super(gameFrame);
        initializeGamePanel();
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
