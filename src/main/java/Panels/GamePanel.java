package Panels;

import lombok.Getter;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class GamePanel extends JPanel {
    @Getter
    BoardPanel boardPanel;
    @Getter ScorePanel scorePanel;
    public GamePanel(){
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(10, 50, 10, 50));
        boardPanel = new BoardPanel();
        add(boardPanel, BorderLayout.WEST);
        boardPanel.setLayout(new GridBagLayout());
        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.EAST);
    }
}
