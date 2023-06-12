package GameGUI.Panels;

import GameGUI.Buttons.MenuButton;
import GameGUI.GameFrame;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MenuPanel extends JPanel {
    MenuButton startGame;
    MenuButton scoreBoard;
    MenuButton exitGame;
    GameFrame gameFrame;
    ArrayList<MenuButton> buttons;

    public MenuPanel(){
        gameFrame = GameFrame.getInstance();
        initializeMenu();
    }
    void initializeMenu(){
        initializeButtons();
        addToButtonsList();
        addButtonListeners();
        setProperties();
        addButtons();
    }
    void setProperties(){
        setMaximumSize(new Dimension(400,500));
        setLayout(new GridBagLayout());
    }

    void initializeButtons() {
        startGame = new MenuButton("Start Game!");
        scoreBoard = new MenuButton("Best Scores");
        exitGame = new MenuButton("Exit game");
        buttons = new ArrayList<>();
    }
    void addToButtonsList(){
        buttons.add(startGame);
        buttons.add(scoreBoard);
        buttons.add(exitGame);
    }
    void addButtonListeners(){
        startGame.addActionListener(e -> gameFrame.openGameWindow());
        scoreBoard.addActionListener(e -> gameFrame.openBestScoresWindow());
        exitGame.addActionListener(e -> System.exit(0));
    }
    void addButtons(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.gridx=0;
        gbc.gridy=0;
        gbc.fill = GridBagConstraints.CENTER;
        add(startGame, gbc);
        gbc.gridx=0;
        gbc.gridy=1;
        gbc.fill = GridBagConstraints.CENTER;
        add(scoreBoard,gbc);
        gbc.gridx=0;
        gbc.gridy=2;
        gbc.fill = GridBagConstraints.CENTER;
        add(exitGame,gbc);
    }


}
