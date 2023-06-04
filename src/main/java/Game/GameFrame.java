package Game;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame{
    public GameFrame(String title) {
        super(title);
        initializeGameFrame();
        new MenuWindow(this);
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


}
