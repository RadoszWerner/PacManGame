package Panels;

import javax.swing.*;
import java.awt.*;

public class ScorePanel extends JPanel {
    JPanel time;
    JPanel score;
    JPanel lives;
    JLabel livesAmount;
    JLabel timeAmount;
    JLabel scoreAmount;
    public ScorePanel(){
        time = new JPanel();
        score = new JPanel();
        lives = new JPanel();
        livesAmount = new JLabel("1");
        timeAmount = new JLabel("2");
        scoreAmount = new JLabel("3");
        JLabel livesDescription = new JLabel("Lives: ");
        JLabel timeDescription = new JLabel("Time: ");
        JLabel scoreDescription = new JLabel("Score: ");
        setLayout(new BorderLayout());
        time.add(timeDescription);
        time.add(timeAmount);
        lives.add(livesDescription);
        lives.add(livesAmount);
        score.add(scoreDescription);
        score.add(scoreAmount);
        add(time, BorderLayout.NORTH );
        add(lives, BorderLayout.CENTER );
        add(score, BorderLayout.SOUTH );

    }

    public void updateAmounts(int scoreFromGame, String timeFromGame,int livesFromGame){
        livesAmount.setText(String.valueOf(livesFromGame));
        timeAmount.setText(String.valueOf(timeFromGame));
        scoreAmount.setText(String.valueOf(scoreFromGame));

    }
}
