package Game;

import Board.Board;
import Collision.Collision;
import Collision.PacManPointCollision;
import Collision.PacManWallCollision;
import Collision.PacManGhostCollision;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

public class GameEngine {
    Board board;
    @Getter @Setter int points;
    @Getter @Setter int time;
    boolean gameOver;
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
    }
    void runThreads(){
        for (Thread gameThread:gameThreads) {
            gameThread.start();
        }
    }
    void play(){
        while (!gameOver){
            for (Collision collision:collisions) {
                collision.checkCollision();
            }
            board.updateBoard();

        }
    }

    public void startGame(){
        initializeCollisions();
        initializeGameThreads();
        runThreads();
        play();

    }
    public GameEngine()  {
        gameOver = false;
        board = new Board();
        startGame();
    }
}
