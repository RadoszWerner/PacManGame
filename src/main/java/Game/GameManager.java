package Game;

import javax.swing.*;
import java.awt.*;

public class GameManager {
    JFrame gameFrame;
    public GameManager(){
        initializeGameFrame();
        new GameMenu(gameFrame);
    }
    void setGameFrameSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        gameFrame.setSize(screenWidth, screenHeight);
    }
    void setGameFrameProperties(){
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gameFrame.getContentPane().setLayout(new GridBagLayout());
        gameFrame.setFocusable(true);
        gameFrame.requestFocus();
        gameFrame.setVisible(true);
    }
    void initializeGameFrame(){
        gameFrame = new JFrame("PacMan");
        setGameFrameProperties();
        setGameFrameSize();
    }

}
