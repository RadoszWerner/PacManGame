package GameGUI.Panels;

import GameGUI.Buttons.MenuButton;
import GameGUI.GameFrame;
import GameGUI.MenuWindow;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.io.FileWriter;
import java.io.IOException;

public class GameOverPanel extends JPanel {
    GameFrame gameFrame;
    @Setter @Getter static private int points;
    @Setter @Getter static private double time;

    JTextField usernameField;

    public GameOverPanel(int points, double time){
        setPoints(points);
        setTime(time);
        gameFrame = GameFrame.getInstance();
        initializeGameOverPanel();
    }
    void initializeGameOverPanel(){
        setLayout(new GridBagLayout());
        setPreferredSize(new Dimension(300, 200));
        initializeMsg();
        initializeScore();
        initializeMainMenuButton();
    }

    private void initializeScore() {
        initializePoints();
        initializeTime();
        initializeUserName();
        initializeSaveButton();
    }

    void initializeMsg(){
        JLabel gameOverLabel = new JLabel("Game Over");
        gameOverLabel.setFont(new Font("Arial", Font.BOLD, 70));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.CENTER;
        add(gameOverLabel, gbc);
    }

    private void initializePoints() {
        JLabel pointsLabel = new JLabel("Points: " + points);
        pointsLabel.setFont(new Font("Arial", Font.BOLD, 35));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.CENTER;
        add(pointsLabel, gbc);
    }
    private void initializeTime() {
        JLabel timeLabel = new JLabel("Time: " + time);
        timeLabel.setFont(new Font("Arial", Font.BOLD, 35));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill = GridBagConstraints.CENTER;
        add(timeLabel, gbc);
    }
    private void initializeUserName() {
        usernameField = new JTextField();
        usernameField.setFont(new Font("Arial", Font.BOLD, 35));
        usernameField.setPreferredSize(new Dimension(300,50));
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=3;
        gbc.fill = GridBagConstraints.CENTER;
        usernameField.setHorizontalAlignment(JTextField.CENTER);
        add(usernameField, gbc);
    }
    private void initializeSaveButton() {
        MenuButton commitButton = new MenuButton("Commit");
        commitButton.addActionListener(e -> {
            String username = usernameField.getText();
//            System.out.println("Username: " + username);
            try{
                FileWriter fileWriter = new FileWriter("scores.txt", true);
                fileWriter.write(username+","+points+","+time);
                fileWriter.close();
                System.out.println("Username saved to file.");
            }
            catch (IOException ex){
                System.out.println("Error error format C:");
            }
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=4;
        gbc.fill = GridBagConstraints.CENTER;
        add(commitButton, gbc);
    }


    void initializeMainMenuButton(){
        MenuButton mainMenu = new MenuButton("Main Menu");
        mainMenu.addActionListener(e -> {
            gameFrame.getContentPane().removeAll();
            gameFrame.repaint();
            new MenuWindow();
        });
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=5;
        gbc.fill = GridBagConstraints.CENTER;
        add(mainMenu, gbc);

    }
}
