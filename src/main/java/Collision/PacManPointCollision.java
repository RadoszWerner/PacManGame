package Collision;

import Board.BoardItem;
import Board.Floor;
import Board.PacMan;
import Board.Point;
import Utils.DirectionChecker;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;

@AllArgsConstructor
public class PacManPointCollision implements Collision
{
    PacMan pacMan;
    ArrayList<Point> points;
    ArrayList<Floor> floors;


    private void changeToFloor(Point point) {
        Floor floor = new Floor(point.getX(), point.getY());
        points.remove(point);
        floors.add(floor);
    }

    @Override
    public void checkCollision() {
        for (Point point:points) {
            int pacManX = pacMan.getX();
            int pacManY = pacMan.getY();
            int pointX = point.getX();
            int pointY = point.getY();
            if(DirectionChecker.checkCentre(pacManX, pacManY, pointX, pointY)) {
                changeToFloor(point);
                break;
            }
        }
    }
}

