package GameGUI;

import javax.swing.*;
import java.awt.*;

public class GameOverWindow extends Window {
    JPanel centralPanel;
    public GameOverWindow(){
        super();
        initializeGameOver();
    }
    void initializeGameOver(){
        JPanel panel = new JPanel();
        centralPanel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setPreferredSize(new Dimension(300, 200));
        centralPanel.setPreferredSize(new Dimension(300, 200));
        centralPanel = new JPanel();
        panel.add(centralPanel, BorderLayout.CENTER);

        initializeMsg();
        initializeButton();
        gameFrame.getContentPane().add(panel);
        gameFrame.setVisible(true);
    }

    void initializeMsg(){
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 24));
        centralPanel.add(gameOverLabel);
    }

    void initializeButton(){
        JButton mainMenu = new JButton("Main Menu");
        mainMenu.addActionListener(e -> {
            gameFrame.getContentPane().removeAll();
            gameFrame.repaint();
            new MenuWindow();


        });
        centralPanel.add(mainMenu);

    }
}