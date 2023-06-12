package GameGUI;

import GameGUI.Panels.BestScoresPanel;

public class BestScoresWindow extends Window{
    public BestScoresWindow(){
        super();
        initializeBestScores();
    }

    private void initializeBestScores() {
        BestScoresPanel panel = new BestScoresPanel();
        gameFrame.getContentPane().add(panel);
        gameFrame.setVisible(true);
    }

}
