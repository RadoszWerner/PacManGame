package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    private static GameFrame instance;
    private final static String GAME_TITLE = "PacMan";
    private GameFrame() {
        super(GAME_TITLE);
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
    public void openGameOverWindow(){
        getContentPane().removeAll();
        new GameOverWindow();
    }
    public void openMenuWindow() {
        getContentPane().removeAll();
        new MenuWindow();
    }
}
