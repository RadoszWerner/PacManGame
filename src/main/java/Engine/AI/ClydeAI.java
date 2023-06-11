package Engine.AI;

import GameGUI.Panels.Board.Ghost;
import lombok.AllArgsConstructor;

import java.util.Random;
@AllArgsConstructor
public class ClydeAI implements AI{
    Ghost clyde;
    @Override
    public void setDirection() {
//        System.out.println(clyde.isMoving());
        if(!clyde.isMoving()){
            Random random = new Random();
            int randomNumber = random.nextInt(4) + 37;
            clyde.setPlannedDirection(randomNumber);
            clyde.setMoving(true);
        }
    }
}
