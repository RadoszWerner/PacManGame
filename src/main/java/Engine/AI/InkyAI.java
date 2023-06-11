package Engine.AI;

import lombok.AllArgsConstructor;

import java.util.Random;
@AllArgsConstructor
public class InkyAI implements AI{
    PinkyAI pinkyAI;
    ClydeAI clydeAI;
    int counter;
    int chosenNumber;
    @Override
    public void setDirection() {
        if(counter%100==0){
            Random random = new Random();
            int randomNumber = random.nextInt(2) + 1;
            chosenNumber = randomNumber;
        }
        if(chosenNumber == 1) pinkyAI.setDirection();
        if(chosenNumber == 2) clydeAI.setDirection();
        counter++;
    }
}
