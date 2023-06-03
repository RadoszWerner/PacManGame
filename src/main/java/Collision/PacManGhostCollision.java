package Collision;

import Board.Ghost;
import Board.PacMan;
import Board.Point;
import Utils.DirectionChecker;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
@AllArgsConstructor
public class PacManGhostCollision implements Collision{
    PacMan pacMan;
    ArrayList<Ghost> ghosts;
    @Override
    public void checkCollision() {
        for (Ghost ghost:ghosts) {
            int pacManX = pacMan.getX();
            int pacManY = pacMan.getY();
            int ghostX = ghost.getX();
            int ghostY = ghost.getY();
            if(DirectionChecker.checkCentre(pacManX, pacManY, ghostX, ghostY)) {
                pacMan.die();
                break;
            }
        }
    }
}
