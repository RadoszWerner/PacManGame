package GameGUI.Panels.Board;


import GameGUI.Panels.GamePanel;
import Utils.CartesianHelper;
import Utils.DirectionChecker;
import Utils.GameConstants;
import lombok.Getter;
import lombok.Setter;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import Utils.GameConstants;

public class Board extends JPanel {
   
    @Getter @Setter
    GamePanel gamePanel;


    @Getter @Setter SlowPacMan slowPacMan;
    @Getter @Setter Blinky blinky;
    @Getter @Setter Clyde clyde;
    @Getter @Setter Inky inky;
    @Getter @Setter ArrayList<DynamicItem> dynamicItems;
    @Getter @Setter ArrayList<BoardItem> boardItems;
    @Getter @Setter ArrayList<Point> points;
    @Getter @Setter ArrayList<JPanel> panels;
    @Getter @Setter ArrayList<Wall> walls;
    @Getter @Setter ArrayList<Floor> floors;
    @Getter @Setter ArrayList<Ghost> ghosts;

    void initializePanels(){
        panels = new ArrayList<>();
    }
    void initializeBoardItems(){
        slowPacMan = new SlowPacMan();
        blinky = new Blinky();
        clyde = new Clyde();
        inky = new Inky();
        dynamicItems = new ArrayList<>();
        boardItems = new ArrayList<>();
        points = new ArrayList<>();
        walls = new ArrayList<>();
        floors = new ArrayList<>();
        ghosts = new ArrayList<>();
    }
    void initializeBoardElements(){
        initializePanels();
        initializeBoardItems();
    }
    void generateVerticalWalls(){
        for (int i = 2; i < 7; i++) {
            walls.add(new Wall(i, 5));
        }
        for (int i = 10; i < 13; i++) {
            walls.add(new Wall(i, 5));
        }

        for (int i = 21; i < 28; i++) {
            walls.add(new Wall(i, 5));
        }
        for (int i = 4; i < 7; i++) {
            walls.add(new Wall(i, 8));
            walls.add(new Wall(i, 10));
        }

        for (int i = 2; i < 8; i++) {
            walls.add(new Wall(i, 15));
        }
        for (int i = 9; i < 13; i++) {
            walls.add(new Wall(i, 15));
        }
        for (int i = 18; i < 23; i++) {
            walls.add(new Wall(i, 15));
        }
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

        for (int i = 23; i <28 ; i++) {
            walls.add(new Wall(i, 10));
        }

        for (int i = 13; i < 17; i++) {
            walls.add(new Wall(i, 8));
        }
        for (int i = 14; i < 16; i++) {
            walls.add(new Wall(i, 7));
        }
    }
    void generateHorizontalWalls(){

        for (int i = 5; i < 13; i++) {
            walls.add(new Wall(2, i));
            walls.add(new Wall(8, i));
            walls.add(new Wall(10, i));
            walls.add(new Wall(29, i));
            walls.add(new Wall(21, i));
            walls.add(new Wall(19, i));
        }
        for (int i = 14; i < 17; i++) {
            walls.add(new Wall(2, i));
            walls.add(new Wall(14, i));
            walls.add(new Wall(17, i));
        }
    }
    void generateSingleWalls(){
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
        walls.add(new Wall(8,5));
        walls.add(new Wall(14,5));
        walls.add(new Wall(19,5));
        walls.add(new Wall(29,5));
        walls.add(new Wall(6, 6));
        walls.add(new Wall(6, 7));
        walls.add(new Wall(4, 7));
        walls.add(new Wall(5, 11));
        walls.add(new Wall(5, 12));
        walls.add(new Wall(24, 13));
        walls.add(new Wall(24, 14));
        walls.add(new Wall(29, 15));
        walls.add(new Wall(23, 7));
        walls.add(new Wall(24, 7));
        walls.add(new Wall(26, 7));
        walls.add(new Wall(27, 7));
        walls.add(new Wall(23, 8));
        walls.add(new Wall(27, 8));
        walls.add(new Wall(25, 9));
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
    void generateWalls()  {
         generateVerticalWalls();
         generateHorizontalWalls();
         generateSingleWalls();
    }
    void generateBorders(){
        for (int yIndex = 0; yIndex <GameConstants.SQUARE_AMOUNT_Y ; yIndex++) {
            for (int xIndex = 0; xIndex < GameConstants.SQUARE_AMOUNT_X; xIndex++) {
                if(yIndex==0 || xIndex==0 || yIndex ==GameConstants.SQUARE_AMOUNT_Y-1 || xIndex==GameConstants.SQUARE_AMOUNT_X-1){
                    Wall wall = new Wall(xIndex,yIndex);
                    walls.add(wall);
                }
            }
        }
    }
    boolean isThereBackground(int x, int y){
        boolean isBackground = true;
        for (BoardItem boardItem:walls) {
            if (x == boardItem.getX() && y == boardItem.getY()) {
                isBackground = false;
                break;
            }
        }
        return isBackground;
    }
    void generateBackground(){
        points.clear();
        for (int yIndex = 0; yIndex <GameConstants.SQUARE_AMOUNT_Y ; yIndex++) {
            for (int xIndex = 0; xIndex < GameConstants.SQUARE_AMOUNT_X; xIndex++) {
                if(isThereBackground(xIndex, yIndex)){
                    Point point = new Point(xIndex,yIndex);
                    points.add(point);
                }
            }
        }
    }
    void generateGhosts(){
        ghosts.add(blinky);
        ghosts.add(inky);
        ghosts.add(clyde);
    }
    void addToBoardItems(){
        boardItems.addAll(points);
        boardItems.addAll(walls);
        boardItems.addAll(floors);
        boardItems.addAll(ghosts);
        boardItems.add(slowPacMan);

    }
    void generateDynamicItems(){
        dynamicItems.add(slowPacMan);
        dynamicItems.addAll(ghosts);
    }
    void generateBoardItems()  {

        generateWalls();
        generateBorders();
        generateBackground();
        generateGhosts();
        generateDynamicItems();
        addToBoardItems();

    }
    void generatePanels(){
        int squareWidth = GameConstants.WIDTH / GameConstants.SQUARE_AMOUNT_X;
        int squareHeight = GameConstants.HEIGHT / GameConstants.SQUARE_AMOUNT_Y;
        for (int yIndex = 0; yIndex <GameConstants.SQUARE_AMOUNT_Y ; yIndex++) {
            for (int xIndex = 0; xIndex < GameConstants.SQUARE_AMOUNT_X; xIndex++) {
                JPanel panel = new JPanel();
                panel.setPreferredSize(new Dimension(squareWidth, squareHeight));
                GridBagConstraints constraints = new GridBagConstraints();
                constraints.gridx = xIndex;
                constraints.gridy = yIndex;
                add(panel, constraints);
                panels.add(panel);
            }
        }
    }

    void drawItem(int x, int y, Color color){
        int panelIndex = CartesianHelper.getIndexByCoordinates(x,y,GameConstants.SQUARE_AMOUNT_X);
        panels.get(panelIndex).setBackground(color);
    }
    void generateBoard()  {
        initializeBoardElements();
        generateBoardItems();
        generatePanels();
        for (BoardItem boardItem:boardItems) {
                drawItem(boardItem.getX(),boardItem.getY(),boardItem.color);
        }

    }
    void updateBoardItems(){
    boardItems.clear();
        addToBoardItems();
    }
    boolean checkIfNearToDynamicItem(BoardItem itemToCheck, int x,int y){
        int xToCheck = itemToCheck.getX();
        int yToCheck = itemToCheck.getY();
        return (itemToCheck.getX() == x && itemToCheck.getY() == y
                || DirectionChecker.checkUp(xToCheck, yToCheck, x,y)
                || DirectionChecker.checkDown(xToCheck, yToCheck, x,y)
                || DirectionChecker.checkRight(xToCheck, yToCheck, x,y)
                || DirectionChecker.checkLeft(xToCheck, yToCheck, x,y));
    }
    boolean isNearDynamicItem(int x, int y){
         boolean isNear = false;
         for (DynamicItem dynamicItem:dynamicItems) {
            if(checkIfNearToDynamicItem(dynamicItem, x, y)){
                isNear = true;
                break;
            }
         }
        return isNear;
    }
    public void updateBoard(){
        for (BoardItem boardItem:boardItems) {
            int x = boardItem.getX();
            int y = boardItem.getY();
            if(isNearDynamicItem(x, y)){
               drawItem(x,y,boardItem.color);
            }
        }
        updateBoardItems();

    }
    public Board()  {
        setLayout(new GridBagLayout());
        generateBoard();
    }
}
