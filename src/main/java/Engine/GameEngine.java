package Engine;

import Engine.AI.BlinkyAI;
import Engine.Collision.Collision;
import Engine.Collision.PacManGhostCollision;
import Engine.Collision.PacManPointCollision;
import Engine.Collision.DynamicItemWallCollision;
import GameGUI.Panels.Board.Board;
import GameGUI.Panels.Board.PacMan;
import GameGUI.Panels.GamePanel;
import GameGUI.Panels.ScorePanel;
import lombok.Getter;
import lombok.Setter;

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


    ArrayList<Thread> gameThreads;
    ArrayList<Collision> collisions;
    void initializeCollisions(){
        collisions = new ArrayList<>();
        collisions.add(new DynamicItemWallCollision(board.getSlowPacMan(), board.getWalls()));
        collisions.add(new PacManPointCollision(board.getSlowPacMan(), board.getPoints(), board.getFloors()));
        collisions.add(new PacManGhostCollision(board.getSlowPacMan(), board.getGhosts()));
        collisions.add(new DynamicItemWallCollision(board.getBlinky(), board.getWalls()));

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
            blinkyAI.setDirection();
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
