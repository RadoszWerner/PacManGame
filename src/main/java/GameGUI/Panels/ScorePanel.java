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
       generatePanel();
    }
    void generatePanel(){
        initializePanels();
        initializeLabels();
        initializeLists();
        addToLists();
        setProperties();
        generatePanels();
    }
    void initializePanels(){
        time = new JPanel();
        score = new JPanel();
        lives = new JPanel();
    }
    void initializeLabels(){
        livesAmount = new JLabel();
        timeAmount = new JLabel();
        scoreAmount = new JLabel();
        livesDescription = new JLabel("Lives: ");
        scoreDescription = new JLabel("Score: ");
    }
    void initializeLists(){
        panels = new ArrayList<>();
        labels = new ArrayList<>();
    }
    void addToLists(){
        addToPanelsList();
        addToLabelsList();
    }
    void addToLabelsList(){
        labels.add(timeAmount);
        labels.add(scoreAmount);
        labels.add(scoreDescription);
        labels.add(livesAmount);
        labels.add(livesDescription);
    }
    void addToPanelsList(){
        panels.add(time);
        panels.add(score);
        panels.add(lives);
    }
    void setProperties(){
        setLabelsProperties();
        setPanelsProperties();
        setLayout(new BorderLayout());
    }
    void setPanelsProperties(){
        for (JPanel panel: panels) {
            panel.setPreferredSize(new Dimension(200,50));
        }
    }
    void setLabelsProperties(){
        for (JLabel label: labels) {
            label.setFont( new Font("Arial", Font.BOLD, 35));
        }
        timeAmount.setPreferredSize(new Dimension(100,50));
    }
    void generatePanels(){
        generateTimePanel();
        generateScorePanel();
        generateLivesPanel();
    }
    void generateTimePanel(){
        time.add(timeAmount);
        add(time, BorderLayout.NORTH );
    }
    void generateScorePanel(){
        lives.add(livesDescription);
        lives.add(livesAmount);
        add(lives, BorderLayout.SOUTH );
    }
    void generateLivesPanel(){
        score.add(scoreDescription);
        score.add(scoreAmount);
        add(score, BorderLayout.CENTER );
    }
    public void updateAmounts(int scoreFromGame, String timeFromGame,int livesFromGame){
        livesAmount.setText(String.valueOf(livesFromGame));
        timeAmount.setText(String.valueOf(timeFromGame));
        scoreAmount.setText(String.valueOf(scoreFromGame));

    }
}
