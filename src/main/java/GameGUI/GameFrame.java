package GameGUI;

import Utils.GameConstants;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private static GameFrame instance;

    private GameFrame() {
        super(GameConstants.GAME_TITLE);
        initializeGameFrame();
    }
    public static GameFrame getInstance() {
        if (instance == null) {
            instance = new GameFrame();
        }
        return instance;
    }
    void setGameFrameSize(){
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        setSize(screenWidth, screenHeight);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }
    void setGameFrameProperties(){
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setFocusable(true);
        requestFocus();
        setVisible(true);
    }
    void initializeGameFrame(){
        setGameFrameProperties();
        setGameFrameSize();
    }
    public void openGameWindow() {
        getContentPane().removeAll();
        new GameWindow();
    }
    public void openGameOverWindow(int points, double time){
        getContentPane().removeAll();
        new GameOverWindow(points, time);
    }
    public void openMenuWindow() {
        getContentPane().removeAll();
        new MenuWindow();
    }

    public void openBestScoresWindow() {
        getContentPane().removeAll();
        new BestScoresWindow();
    }
}
