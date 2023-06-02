package Game;

import Board.Board;
import Collision.PacManWallCollision;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.util.ArrayList;

public class GameEngine {
    Board board;
    @Getter @Setter int points;
    @Getter @Setter int time;
    ArrayList<Thread> gameThreads;
    PacManWallCollision pacManWallCollision;
    void initializeCollisions(){
        pacManWallCollision = new PacManWallCollision();
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
        while (true){
            pacManWallCollision.checkCollision(board.getWalls(), board.getSlowPacMan());
            board.updateBoard();
        }
    }

    public void startGame(){
        initializeCollisions();
        initializeGameThreads();
        runThreads();
        play();

    }
    public GameEngine() {
        board = new Board();
        startGame();

    }
}
