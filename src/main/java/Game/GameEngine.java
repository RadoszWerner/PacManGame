package Game;

import Board.Board;
import lombok.Getter;
import lombok.Setter;

import javax.swing.*;

public class GameEngine {
    @Getter @Setter private Board board;
    @Getter @Setter private int points;
    @Getter @Setter private int time;

    public GameEngine() {
        new Board();
    }
}
