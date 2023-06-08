package GameGUI.Panels;

import GameGUI.GameFrame;

import javax.swing.*;

public class MenuPanel extends JPanel {
    JButton startGame;
    JButton scoreBoard;
    JButton exitGame;

    GameFrame gameFrame;

    public MenuPanel(){
        gameFrame = GameFrame.getInstance();
        initializeMenu();
    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");
        startGame.addActionListener(e -> {
            gameFrame.openGameWindow();
        });
        exitGame.addActionListener(e -> {
            System.exit(0);
        });

    }

    void initializeMenu(){
        initializeButtons();
        add(startGame);
        add(scoreBoard);
        add(exitGame);
    }
}
