package Board;

import Collision.PacManWallCollision;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Board {
    final  int width = 1600;
    final  int height = 900;
    final  int squareAmountX = 64;
    final  int squareAmountY = 36;
     SlowPacMan slowPacMan;
     ArrayList<BoardItem> boardItems;
     ArrayList<Point> points;
     ArrayList<JPanel> panels;
     ArrayList<Wall> walls;
     PacManWallCollision pacManWallCollision;
     JFrame gameFrame;

     void listenToKeyboard(){
         gameFrame.addKeyListener(new KeyListener() {
             @Override
             public void keyTyped(KeyEvent e) {
             }
             @Override
             public void keyPressed(KeyEvent e) {
                 slowPacMan.setMoving(true);
                 slowPacMan.direction = e.getKeyCode();
             }
             @Override
             public void keyReleased(KeyEvent e) {
             }
         });
     }
     void setGameFrameSize(){
         Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
         int screenWidth = (int) screenSize.getWidth();
         int screenHeight = (int) screenSize.getHeight();
         gameFrame.setSize(screenWidth, screenHeight);
     }
     void setGameFrameProperties(){
         gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         gameFrame.getContentPane().setLayout(new GridBagLayout());
         gameFrame.setFocusable(true);
     }
     void initializeGameFrame(){
         gameFrame = new JFrame("PacMan");
         setGameFrameProperties();
         setGameFrameSize();
         listenToKeyboard();

     }
    void initializeBoardItems(){
        slowPacMan = new SlowPacMan(5,5);
        boardItems = new ArrayList<>();
        points = new ArrayList<>();
        walls = new ArrayList<>();
    }
    void initializeCollisions(){
        pacManWallCollision = new PacManWallCollision(walls, slowPacMan);
    }
    void initializePanels(){
        panels = new ArrayList<>();
    }
    void initializeBoardElements(){
        initializePanels();
        initializeBoardItems();
        initializeCollisions();
    }
    void generateWalls(){
        for (int i = 0; i <squareAmountY ; i++) {
            for (int j = 0; j < squareAmountX; j++) {
                if(i==0 || j==0 || i ==squareAmountY-1 || j==squareAmountX-1){
                    Wall wall = new Wall(j,i);
                    walls.add(wall);
                } else {
                    Point point = new Point(j,i);
                    points.add(point);
                }
            }
        }
        boardItems.addAll(walls);
        boardItems.addAll(points);
    }
    void generateBoardItems(){
        generateWalls();
        boardItems.add(slowPacMan);
    }
    void generatePanels(){
        int squareWidth = width / squareAmountX;
        int squareHeight = height / squareAmountY;
        for (int i = 0; i <squareAmountY ; i++) {
            for (int j = 0; j < squareAmountX; j++) {
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(squareWidth, squareHeight));
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = j;
                constraints.gridy = i;
                gameFrame.add(panel, constraints);
                panels.add(panel);
            }
        }
    }

    void generateBoard(){
        initializeBoardElements();
        generateBoardItems();
        generatePanels();

    }
    void updateBoard(){
        pacManWallCollision.checkCollision();
        for (BoardItem boardItem:boardItems) {
            panels.get((boardItem.getY())*(squareAmountX)+boardItem.getX()).setBackground(boardItem.color);
        }
        gameFrame.setVisible(true);
    }
    void startGame(){
        updateBoard();
        Thread gameThread = new Thread(slowPacMan);
        gameThread.start();
        while (true){
            updateBoard();
        }
    }

    public Board() {
        initializeGameFrame();
        generateBoard();
        startGame();
    }
}
