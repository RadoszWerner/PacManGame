package Engine.AI;

import lombok.AllArgsConstructor;

import java.util.Random;
@AllArgsConstructor
public class InkyAI implements AI{
    BlinkyAI blinkyAI;
    ClydeAI clydeAI;
    PinkyAI pinkyAI;
    int counter;
    int chosenNumber;
    @Override
    public void setDirection() {
        if(counter%100==0){
            Random random = new Random();
            int randomNumber = random.nextInt(3) + 1;
            chosenNumber = randomNumber;
        }
        if(chosenNumber == 1) blinkyAI.setDirection();
        if(chosenNumber == 2) clydeAI.setDirection();
        if(chosenNumber == 3) pinkyAI.setDirection();
        counter++;
    }
}
