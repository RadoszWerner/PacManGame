package Engine;

import Engine.AI.BlinkyAI;
import Engine.AI.ClydeAI;
import Engine.AI.InkyAI;
import Engine.AI.PinkyAI;
import Engine.Collision.Collision;
import Engine.Collision.PacManGhostCollision;
import Engine.Collision.PacManPointCollision;
import Engine.Collision.DynamicItemWallCollision;
import GameGUI.Panels.Board.Board;
import GameGUI.Panels.GamePanel;
import GameGUI.Panels.ScorePanel;
import lombok.Getter;
import lombok.Setter;

import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameEngine implements Runnable {
    Board board;
    ScorePanel scorePanel;
    @Getter @Setter int points;
    @Getter @Setter double time;
    GamePanel gamePanel;
    long startTime;
    BlinkyAI blinkyAI;
    ClydeAI clydeAI;
    PinkyAI pinkyAI;
    InkyAI inkyAI;

    ArrayList<Thread> gameThreads;
    ArrayList<Collision> collisions;
    void initializeCollisions(){
        collisions = new ArrayList<>();
        collisions.add(new DynamicItemWallCollision(board.getSlowPacMan(), board.getWalls()));
        collisions.add(new PacManPointCollision(board.getSlowPacMan(), board.getPoints(), board.getFloors()));
        collisions.add(new PacManGhostCollision(board.getSlowPacMan(), board.getGhosts()));
        collisions.add(new DynamicItemWallCollision(board.getBlinky(), board.getWalls()));
        collisions.add(new DynamicItemWallCollision(board.getClyde(), board.getWalls()));
        collisions.add(new DynamicItemWallCollision(board.getInky(), board.getWalls()));
        collisions.add(new DynamicItemWallCollision(board.getPinky(), board.getWalls()));

    }
    void initializeGameThreads(){
        gameThreads = new ArrayList<>();
        gameThreads.add( new Thread(board.getSlowPacMan())) ;
        gameThreads.add( new Thread(board.getBlinky())) ;
        gameThreads.add( new Thread(board.getInky())) ;
        gameThreads.add( new Thread(board.getPinky())) ;
        gameThreads.add( new Thread(board.getClyde())) ;
    };
    void runThreads(){
        for (Thread gameThread:gameThreads) {
            gameThread.start();
        }
    }

    void play(){
        while (!gameOver()){
            for (Collision collision:collisions) {
                collision.checkCollision();
            }
            blinkyAI.setDirection();
            clydeAI.setDirection();
            pinkyAI.setDirection();
            inkyAI.setDirection();
            long currentTime = System.currentTimeMillis();
            time =((double) currentTime - (double) startTime)/1000;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            scorePanel.updateAmounts(board.getFloors().size(), decimalFormat.format(time), board.getSlowPacMan().getLives());
            gamePanel.updateGame();
        }
        gamePanel.finishGame();
    }
    boolean gameOver(){
        return (board.getPoints().size()==0 || board.getSlowPacMan().getLives()==0);
    }

    public void startGame(){

        initializeCollisions();
        blinkyAI = new BlinkyAI(board.getSlowPacMan(), board.getBlinky(), (DynamicItemWallCollision) collisions.get(3));
        board.getClyde().setPlannedDirection(KeyEvent.VK_DOWN);
        clydeAI = new ClydeAI(board.getClyde());
        inkyAI = new InkyAI(new BlinkyAI(board.getSlowPacMan(), board.getInky(), (DynamicItemWallCollision) collisions.get(5)),new ClydeAI(board.getInky()), new PinkyAI(board.getSlowPacMan(), board.getInky()),1, 1);
        pinkyAI = new PinkyAI(board.getSlowPacMan(), board.getPinky());
        initializeGameThreads();
        runThreads();
    }
    public GameEngine(GamePanel gamePanel)  {
        this.gamePanel = gamePanel;
        board = gamePanel.getBoardPanel();
        scorePanel = gamePanel.getScorePanel();
        startGame();
    }
    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        play();
    }
}
