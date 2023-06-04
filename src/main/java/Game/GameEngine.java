package Game;

import Board.Board;
import Collision.Collision;
import Collision.PacManPointCollision;
import Collision.PacManWallCollision;
import Collision.PacManGhostCollision;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class GameEngine implements Runnable {
    Board board;
    @Getter @Setter int points;
    @Getter @Setter double time;
    JFrame gameFrame;
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
    public void listenToKeyboard(){
        board.getGameFrame().addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
            }
            @Override
            public void keyPressed(KeyEvent e) {
                board.getSlowPacMan().setPlannedDirection(e.getKeyCode());
            }
            @Override
            public void keyReleased(KeyEvent e) {
            }
        });
    }
    void play(){
        while (!gameOver()){
            for (Collision collision:collisions) {
                collision.checkCollision();
            }
            long currentTime = System.currentTimeMillis();
            time =((double) currentTime - (double) startTime)/1000;
            DecimalFormat decimalFormat = new DecimalFormat("#.##");
            board.getGamePanel().getScorePanel().updateAmounts(board.getFloors().size(), decimalFormat.format(time), board.getSlowPacMan().getLives());
            board.updateBoard();
        }
        finishGame();
    }
    boolean gameOver(){
        return (board.getPoints().size()==0 || board.getSlowPacMan().getLives()==0);
    }
    void finishGame(){


        gameFrame.getContentPane().removeAll();
        new GameOver(gameFrame);
    }
    public void startGame(){
        initializeCollisions();
        initializeGameThreads();
        runThreads();
        listenToKeyboard();


    }
    public GameEngine(JFrame gameFrame)  {
        time = 100;
        this.gameFrame = gameFrame;
        board = new Board(gameFrame);
        startGame();
    }
    @Override
    public void run() {
        startTime = System.currentTimeMillis();
        play();
    }
}
