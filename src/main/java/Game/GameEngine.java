package Game;

import Board.Board;

public class GameEngine {
    private Board board;
    private int points;
    private int time;

    public GameEngine(int points, int time) {
        board = new Board();
        this.points = points;
        this.time = time;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    void gameLoop(){

    }
}
