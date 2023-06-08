package GameGUI.Panels;

import GameGUI.Panels.Board.Board;
import GameGUI.GameFrame;
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
    GameFrame gameFrame;
    public GamePanel(){
        gameFrame = GameFrame.getInstance();
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));
        boardPanel = new Board();
        add(boardPanel, BorderLayout.WEST);
        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.EAST);
        listenToKeyboard();
    }
    public void finishGame(){
        gameFrame.openGameOverWindow();
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
