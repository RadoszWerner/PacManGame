package Game;

import Board.Board;
import Collision.PacManPointCollision;
import Collision.PacManWallCollision;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

public class GameEngine {
    Board board;
    @Getter @Setter int points;
    @Getter @Setter int time;
    boolean gameOver;
    ArrayList<Thread> gameThreads;
    PacManWallCollision pacManWallCollision;
    PacManPointCollision pacManPointCollision;
    void initializeCollisions(){
        pacManWallCollision = new PacManWallCollision( board.getSlowPacMan(), board.getWalls());
        pacManPointCollision = new PacManPointCollision(board.getSlowPacMan(), board.getPoints(), board.getFloors());

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
            pacManWallCollision.checkCollision();
            pacManPointCollision.checkCollision();
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
