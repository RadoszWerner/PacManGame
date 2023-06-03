package Game;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;

public class GameMenu {
   @Getter @Setter GameEngine gameEngine;

    public GameMenu()  {

        new GameEngine();
    }
}
