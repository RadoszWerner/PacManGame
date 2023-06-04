package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    public GameFrame(String title) {
        super(title);
        initializeGameFrame();
        openMenuWindow();
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
        new GameWindow(this);
    }
    public void openGameOverWindow(){
        new GameOverWindow(this);
    }
    public void openMenuWindow() {
        new MenuWindow(this);
    }
}
