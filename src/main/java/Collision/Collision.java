package Collision;

import Board.PacMan;
import Board.Wall;

import java.util.ArrayList;

public interface Collision {
    void checkCollision(ArrayList<Wall> walls, PacMan pacMan);
}
