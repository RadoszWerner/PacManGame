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

    public GameMenu()  {
        initializeGameFrame();
        setGameFrameSize();
        setGameFrameProperties();
        initializeMenu();


    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");
//        new GameEngine();
        startGame.addActionListener(e -> {
//            GameEngine game= new GameEngine();

            gameFrame.dispose();
//            SwingUtilities.invokeLater(() -> new GameEngine());
            startGame.setEnabled(false);
            new GameEngine();
            startGame = null;
//            game.startGame();
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
