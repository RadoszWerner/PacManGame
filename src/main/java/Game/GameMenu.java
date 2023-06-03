package Game;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameMenu {
   @Getter @Setter GameEngine gameEngine;
   JFrame gameFrame;
   JPanel menuPanel;
   JButton startGame;
   JButton scoreBoard;
   JButton exitGame;

    public GameMenu(JFrame gameFrame)  {
        this.gameFrame = gameFrame;
        initializeMenu();
        new GameEngine();
    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");

        startGame.addActionListener(e -> {
            menuPanel = null;
            gameFrame.dispose();
            gameFrame = null;
            new GameEngine();
        });
    }
    void initializeMenu(){
        menuPanel = new JPanel();
        initializeButtons();
        menuPanel.add(startGame);
        menuPanel.add(scoreBoard);
        menuPanel.add(exitGame);
        gameFrame.getContentPane().add(menuPanel);
        gameFrame.setVisible(true);
    }
}
