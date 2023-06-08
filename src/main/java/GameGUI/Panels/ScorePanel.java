package GameGUI.Panels;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ScorePanel extends JPanel {
    JPanel time;
    JPanel score;
    JPanel lives;
    JLabel livesAmount;
    JLabel timeAmount;
    JLabel scoreAmount;
    JLabel livesDescription;
    JLabel scoreDescription;
    ArrayList<JLabel> labels;
    ArrayList<JPanel> panels;
    public ScorePanel(){
        time = new JPanel();
        score = new JPanel();
        lives = new JPanel();
        livesAmount = new JLabel();
        timeAmount = new JLabel();
        scoreAmount = new JLabel();
        livesDescription = new JLabel("Lives: ");
        scoreDescription = new JLabel("Score: ");
        panels = new ArrayList<>();
        addToPanelsList();
        labels = new ArrayList<>();
        addToLabelsList();
        setLabelsProperties();
        setPanelsProperties();
        setLayout(new BorderLayout());

        time.add(timeAmount);
        lives.add(livesDescription);
        lives.add(livesAmount);
        score.add(scoreDescription);
        score.add(scoreAmount);
        add(time, BorderLayout.NORTH );
        add(lives, BorderLayout.SOUTH );
        add(score, BorderLayout.CENTER );

    }
    public void addToLabelsList(){
        labels.add(timeAmount);
        labels.add(scoreAmount);
        labels.add(scoreDescription);
        labels.add(livesAmount);
        labels.add(livesDescription);
    }
    public void addToPanelsList(){
        panels.add(time);
        panels.add(score);
        panels.add(lives);
    }
    public void setPanelsProperties(){
        for (JPanel panel: panels) {
            panel.setPreferredSize(new Dimension(200,50));
        }
    }
    public void setLabelsProperties(){
        for (JLabel label: labels) {
            label.setFont( new Font("Arial", Font.BOLD, 35));
        }
        timeAmount.setPreferredSize(new Dimension(100,50));
    }
    public void updateAmounts(int scoreFromGame, String timeFromGame,int livesFromGame){
        livesAmount.setText(String.valueOf(livesFromGame));
        timeAmount.setText(String.valueOf(timeFromGame));
        scoreAmount.setText(String.valueOf(scoreFromGame));

    }
}
