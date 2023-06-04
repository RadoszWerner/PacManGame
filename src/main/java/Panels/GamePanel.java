package Panels;

import Board.Board;
import Game.GameOver;
import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePanel extends JPanel {
    @Getter
    Board boardPanel;
    @Getter ScorePanel scorePanel;
    JFrame gameFrame;
    public GamePanel(JFrame gameFrame){
        this.gameFrame = gameFrame;
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));
        boardPanel = new Board();
        add(boardPanel, BorderLayout.WEST);
        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.EAST);
        listenToKeyboard();
    }
    public void finishGame(){
        gameFrame.getContentPane().removeAll();
        new GameOver(gameFrame);
    }
    public void listenToKeyboard(){
        gameFrame.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                boardPanel.getSlowPacMan().setPlannedDirection(e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    public void updateGame(){
        boardPanel.updateBoard();
        gameFrame.setVisible(true);
    }
}
