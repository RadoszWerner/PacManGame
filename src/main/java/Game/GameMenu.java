package Game;

import Board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class GameMenu extends GameWindow{
   @Getter @Setter GameEngine gameEngine;
   JPanel menuPanel;
   JButton startGame;
   JButton scoreBoard;
   JButton exitGame;


    public GameMenu(JFrame gameFrame)  {
        super(gameFrame);
        initializeMenu();
    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");
        startGame.addActionListener(e -> {
            GameEngine engine = new GameEngine(gameFrame);
            Thread gameThread = new Thread(engine);
            gameFrame.getContentPane().remove(menuPanel);
            gameThread.start();
        });
        exitGame.addActionListener(e -> {
            System.exit(0);
        });

    }
    void initializeMenu(){
        menuPanel = new JPanel();
        initializeButtons();
        gameFrame.getContentPane().add(menuPanel);
        menuPanel.add(startGame);
        menuPanel.add(scoreBoard);
        menuPanel.add(exitGame);
        gameFrame.setVisible(true);
    }
}
