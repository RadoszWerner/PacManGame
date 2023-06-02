package Board;

import Collision.PacManWallCollision;
import Utils.DirectionChecker;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Board {
    final  int width = 1600;
    final  int height = 900;
    final  int squareAmountX = 32;
    final  int squareAmountY = 18;
     @Getter @Setter SlowPacMan slowPacMan;
    @Getter @Setter ArrayList<DynamicItem> dynamicItems;
    @Getter @Setter ArrayList<BoardItem> boardItems;
    @Getter @Setter ArrayList<Point> points;
    @Getter @Setter ArrayList<BoardItem> notBackground;
    @Getter @Setter ArrayList<JPanel> panels;
    @Getter @Setter ArrayList<Wall> walls;

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
        slowPacMan = new SlowPacMan(3,14);
        dynamicItems = new ArrayList<>();
        boardItems = new ArrayList<>();
        points = new ArrayList<>();
        walls = new ArrayList<>();
        notBackground = new ArrayList<>();
    }
    void initializePanels(){
        panels = new ArrayList<>();
    }
    void initializeBoardElements(){
        initializePanels();
        initializeBoardItems();
    }
    void generateWalls(){
        walls = new ArrayList<>();
        walls.add(new Wall(14,1));
        walls.add(new Wall(17,1));
        walls.add(new Wall(24,1));
        walls.add(new Wall(2,2));
        walls.add(new Wall(3,2));
        walls.add(new Wall(4,2));
        walls.add(new Wall(5,2));
        walls.add(new Wall(6,2));
        walls.add(new Wall(8,2));
        walls.add(new Wall(9,2));
        walls.add(new Wall(10,2));
        walls.add(new Wall(11,2));
        walls.add(new Wall(12,2));
        walls.add(new Wall(14,2));
        walls.add(new Wall(19,2));
        walls.add(new Wall(21,2));
        walls.add(new Wall(22,2));
        walls.add(new Wall(24,2));
        walls.add(new Wall(26,2));
        walls.add(new Wall(27,2));
        walls.add(new Wall(28,2));
        walls.add(new Wall(29,2));
        walls.add(new Wall(30,2));
        walls.add(new Wall(2,3));
        walls.add(new Wall(3,3));
        walls.add(new Wall(4,3));
        walls.add(new Wall(5,3));
        walls.add(new Wall(6,3));
        walls.add(new Wall(12,3));
        walls.add(new Wall(14,3));
        walls.add(new Wall(18,3));
        walls.add(new Wall(19,3));
        walls.add(new Wall(22,3));
        walls.add(new Wall(24,3));
        walls.add(new Wall(26,4));
        walls.add(new Wall(27,4));
        walls.add(new Wall(29,4));
        for (int i = 2; i < 7; i++) {
            walls.add(new Wall(i, 5));
        }
        walls.add(new Wall(8,5));
        for (int i = 10; i < 13; i++) {
            walls.add(new Wall(i, 5));
        }
        walls.add(new Wall(14,5));
        walls.add(new Wall(19,5));
        for (int i = 21; i < 28; i++) {
            walls.add(new Wall(i, 5));
        }
        walls.add(new Wall(29,5));
        for (int i = 5; i < 13; i++) {
            walls.add(new Wall(2, i));
            walls.add(new Wall(8, i));
            walls.add(new Wall(10, i));
            walls.add(new Wall(29, i));
            walls.add(new Wall(21, i));
            walls.add(new Wall(19, i));
        }
        for (int i = 4; i < 7; i++) {
            walls.add(new Wall(i, 8));
            walls.add(new Wall(i, 10));
        }
        walls.add(new Wall(6, 6));
        walls.add(new Wall(6, 7));
        for (int i = 2; i < 8; i++) {
            walls.add(new Wall(i, 15));
        }
        for (int i = 9; i < 13; i++) {
            walls.add(new Wall(i, 15));
        }
        for (int i = 18; i < 23; i++) {
            walls.add(new Wall(i, 15));
        }
        for (int i = 14; i < 17; i++) {
            walls.add(new Wall(2, i));
            walls.add(new Wall(14, i));
            walls.add(new Wall(17, i));
        }
        walls.add(new Wall(4, 7));
        walls.add(new Wall(5, 11));
        walls.add(new Wall(5, 12));
        for (int i = 24; i < 28; i++) {
            walls.add(new Wall(i, 16));
        }
        for (int i = 26; i < 30; i++) {
            walls.add(new Wall(i, 12));
            walls.add(new Wall(i, 14));
        }
        for (int i = 21; i < 25; i++) {
            walls.add(new Wall(i, 12));
        }
        walls.add(new Wall(24, 13));
        walls.add(new Wall(24, 14));
        walls.add(new Wall(29, 15));
        for (int i = 23; i <28 ; i++) {
            walls.add(new Wall(i, 10));
        }
        walls.add(new Wall(23, 7));
        walls.add(new Wall(24, 7));
        walls.add(new Wall(26, 7));
        walls.add(new Wall(27, 7));
        walls.add(new Wall(23, 8));
        walls.add(new Wall(27, 8));
        walls.add(new Wall(25, 9));
        for (int i = 13; i < 17; i++) {
            walls.add(new Wall(i, 8));
        }
        for (int i = 14; i < 16; i++) {
            walls.add(new Wall(i, 7));
        }
        walls.add(new Wall(13, 9));
        walls.add(new Wall(16, 9));
        walls.add(new Wall(17, 9));
        walls.add(new Wall(12, 9));
        walls.add(new Wall(12, 10));
        walls.add(new Wall(17, 10));
        walls.add(new Wall(11, 10));
        walls.add(new Wall(18, 10));
        walls.add(new Wall(11, 11));
        walls.add(new Wall(18, 11));
        walls.add(new Wall(14, 4));


    }
    void generateBorders(){
        for (int yIndex = 0; yIndex <squareAmountY ; yIndex++) {
            for (int xIndex = 0; xIndex < squareAmountX; xIndex++) {
                if(yIndex==0 || xIndex==0 || yIndex ==squareAmountY-1 || xIndex==squareAmountX-1){
                    Wall wall = new Wall(xIndex,yIndex);
                    walls.add(wall);
                }
            }
        }
    }
    boolean isBackground(int x, int y){
        boolean isBgc = true;
        for (BoardItem boardItem:notBackground) {
            if(x==boardItem.getX() && y==boardItem.getY()){
                isBgc=false;
            }
        }
        return isBgc;
    }
    void generateBackground(){
        points = new ArrayList<>();
        for (int yIndex = 0; yIndex <squareAmountY ; yIndex++) {
            for (int xIndex = 0; xIndex < squareAmountX; xIndex++) {
                if(isBackground(xIndex, yIndex)){
                    Point point = new Point(xIndex,yIndex);
                    points.add(point);
                }
            }
        }
    }
    void generateBoardItems(){
        generateWalls();
        generateBorders();
        notBackground.addAll(walls);
        generateBackground();
        boardItems.addAll(points);
        boardItems.addAll(walls);
        boardItems.add(slowPacMan);
    }
    void generatePanels(){
        int squareWidth = width / squareAmountX;
        int squareHeight = height / squareAmountY;
        for (int yIndex = 0; yIndex <squareAmountY ; yIndex++) {
            for (int xIndex = 0; xIndex < squareAmountX; xIndex++) {
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(squareWidth, squareHeight));
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = xIndex;
                constraints.gridy = yIndex;
                gameFrame.add(panel, constraints);
                panels.add(panel);
            }
        }
    }
    void generateBoard(){
        initializeBoardElements();
        generateBoardItems();
        generatePanels();

        for (BoardItem boardItem:boardItems) {
                panels.get((boardItem.getY())*(squareAmountX)+boardItem.getX()).setBackground(boardItem.color);
        }

    }
    boolean isUp(int x, int y){
         return DirectionChecker.checkUp(slowPacMan.getX(), slowPacMan.getY(), x,y);
    }
    boolean isDown(int x, int y){
        return DirectionChecker.checkDown(slowPacMan.getX(), slowPacMan.getY(), x,y);
    }
    boolean isLeft(int x, int y){
        return DirectionChecker.checkLeft(slowPacMan.getX(), slowPacMan.getY(), x,y);
    }
    boolean isRight(int x, int y){
        return DirectionChecker.checkRight(slowPacMan.getX(), slowPacMan.getY(), x,y);
    }
    boolean isNearPacMan(int x,int y){
         return (slowPacMan.getX() == x && slowPacMan.getY() == y || isLeft(x,y) || isRight(x,y) || isUp(x,y) || isDown(x,y));
    }
    void updateBoardItems(){
        boardItems.removeAll(points);
        generateBackground();
        boardItems.addAll(0, points);
    }
    public void updateBoard(){
        updateBoardItems();
        for (BoardItem boardItem:boardItems) {
            if(isNearPacMan(boardItem.getX(), boardItem.getY())){
                panels.get((boardItem.getY())*(squareAmountX)+boardItem.getX()).setBackground(boardItem.color);
            }
        }
    gameFrame.setVisible(true);
    }
    public Board() {
        initializeGameFrame();
        generateBoard();
    }
}
