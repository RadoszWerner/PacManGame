package GameGUI.Panels;

import GameGUI.GameFrame;

import javax.swing.*;

public class MenuPanel extends JPanel {
    JButton startGame;
    JButton scoreBoard;
    JButton exitGame;

    GameFrame gameFrame;

    public MenuPanel(GameFrame gameFrame){
        this.gameFrame = gameFrame;
        initializeMenu();
    }
    private void initializeButtons() {
        startGame = new JButton("Start Game!");
        scoreBoard = new JButton("Best Scores");
        exitGame = new JButton("Exit game");
        startGame.addActionListener(e -> {
            gameFrame.openGameWindow();
            gameFrame.getContentPane().remove(this);
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
