package Game;

import Board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class GameMenu {
   @Getter @Setter GameEngine gameEngine;
   JFrame gameFrame;
   JPanel menuPanel;
   JButton startGame;
   JButton scoreBoard;
   JButton exitGame;

   boolean isStartGame;

    public GameMenu()  {
        initializeGameFrame();
        setGameFrameSize();
        setGameFrameProperties();
        initializeMenu();
        isStartGame = false;
    while (!isStartGame){
        System.out.println("dupa");
    }

    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");
        startGame.addActionListener(e -> {
            isStartGame = true;

        });
    }
    void initializeMenu(){
        menuPanel = new JPanel();
        initializeButtons();
        gameFrame.getContentPane().add(menuPanel);
        menuPanel.add(startGame);
        menuPanel.add(scoreBoard);
        menuPanel.add(exitGame);
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
    }
    void initializeGameFrame(){
        gameFrame = new JFrame("PacMan");
        setGameFrameProperties();
        gameFrame.setVisible(true);
    }
}
