package GameGUI;
import GameGUI.Panels.GameOverPanel;
import lombok.Setter;

public class GameOverWindow extends Window {
    @Setter static private int points;
    @Setter static private double time;

    public GameOverWindow(int points, double time){
        super();
        setPoints(points);
        setTime(time);
        initializeGameOver();
    }
    void initializeGameOver(){
        GameOverPanel panel = new GameOverPanel(points, time);
        gameFrame.getContentPane().add(panel);
        gameFrame.setVisible(true);
    }


}
