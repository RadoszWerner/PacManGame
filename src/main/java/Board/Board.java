package Board;

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

    void generatePoints(){
        for (int i = 0; i <squareAmountY ; i++) {
            for (int j = 0; j < squareAmountX; j++) {
                Point point = new Point(j,i);
                points.add(point);
            }
        }
        boardItems.addAll(points);
    }
    void generateWalls(){
        for (int i = 0; i <squareAmountY ; i++) {
            for (int j = 0; j < squareAmountX; j++) {
                if(i==0 || j==0 || i ==squareAmountY-1 || j==squareAmountX-1){
                    Wall wall = new Wall(j,i);
                    walls.add(wall);
                }

            }
        }
        boardItems.addAll(walls);
    }

    void generatePanels(JFrame frame){
        for (int i = 0; i <squareAmountY ; i++) {
            for (int j = 0; j < squareAmountX; j++) {
        int squareWidth = width / squareAmountX;
        int squareHeight = height / squareAmountY;
        JPanel panel = new JPanel();
        panel.setPreferredSize(new Dimension(squareWidth, squareHeight));
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = j;
        constraints.gridy = i;
        frame.getContentPane().add(panel, constraints);
        panels.add(panel);}}
    }
    void generateBoard(JFrame frame){
        panels = new ArrayList<>();


        generatePanels(frame);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int screenWidth = (int) screenSize.getWidth();
        int screenHeight = (int) screenSize.getHeight();
        frame.setSize(screenWidth, screenHeight);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    void updateBoard(){
        
        for (BoardItem boardItem:boardItems) {
            panels.get((boardItem.getY())*(squareAmountX)+boardItem.getX()).setBackground(boardItem.color);
        }
    }

    public Board() {
        slowPacMan = new SlowPacMan(5,5);
        boardItems = new ArrayList<>();
        points = new ArrayList<>();
        walls = new ArrayList<>();
        boardItems.add(slowPacMan);
        generateWalls();
        generatePoints();


        JFrame frame = new JFrame("PacMan");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new GridBagLayout());

        frame.setFocusable(true);

        frame.addKeyListener(new KeyListener() {
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
        generateBoard(frame);
        updateBoard();
        Thread gameThread = new Thread(slowPacMan);
        gameThread.start();
                while (true){
                    if(slowPacMan.isMoving()){
                        updateBoard();
                    }
                }
    }

}
