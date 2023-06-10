package GameGUI.Panels;

import GameGUI.Buttons.MenuButton;
import GameGUI.GameFrame;
import GameGUI.MenuWindow;

import javax.swing.*;
import java.awt.*;

public class GameOverPanel extends JPanel {
    GameFrame gameFrame;
    public GameOverPanel(){
        gameFrame = GameFrame.getInstance();
        initializeGameOverPanel();
    }
    void initializeGameOverPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 200));
        initializeMsg();
        initializeButton();
    }
    void initializeMsg(){
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 70));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.CENTER;
        add(gameOverLabel, gbc);
    }

    void initializeButton(){
        MenuButton mainMenu = new MenuButton("Main Menu");
        mainMenu.addActionListener(e -> {
            gameFrame.getContentPane().removeAll();
            gameFrame.repaint();
            new MenuWindow();
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.CENTER;
        add(mainMenu, gbc);

    }
}
