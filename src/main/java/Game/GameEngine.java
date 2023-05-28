package Game;

import Board.Board;
import lombok.Getter;
import lombok.Setter;

public class GameEngine {
    @Getter @Setter private Board board;
    @Getter @Setter private int points;
    @Getter @Setter private int time;

    public GameEngine(int points, int time) {
        board = new Board();
        this.points = points;
        this.time = time;
    }
}
