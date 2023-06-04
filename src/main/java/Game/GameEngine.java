package Game;

import Board.Board;
import Collision.Collision;
import Collision.PacManPointCollision;
import Collision.PacManWallCollision;
import Collision.PacManGhostCollision;
import Panels.GamePanel;
import Panels.ScorePanel;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameEngine implements Runnable {
    Board board;
    ScorePanel scorePanel;
    @Getter @Setter int points;
    @Getter @Setter double time;
    GamePanel gamePanel;
    long startTime;


    ArrayList<Thread> gameThreads;
    ArrayList<Collision> collisions;
    void initializeCollisions(){
        collisions = new ArrayList<>();
        collisions.add(new PacManWallCollision(board.getSlowPacMan(), board.getWalls()));
        collisions.add(new PacManPointCollision(board.getSlowPacMan(), board.getPoints(), board.getFloors()));
        collisions.add(new PacManGhostCollision(board.getSlowPacMan(), board.getGhosts()));

    }
    void initializeGameThreads(){
        gameThreads = new ArrayList<>();
        gameThreads.add( new Thread(board.getSlowPacMan())) ;
        gameThreads.add( new Thread(board.getBlinky())) ;
        gameThreads.add( new Thread(board.getInky())) ;
        gameThreads.add( new Thread(board.getClyde())) ;}
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
        initializeGameThreads();
        runThreads();



    }
    public GameEngine(GamePanel gamePanel)  {
        time = 100;
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
