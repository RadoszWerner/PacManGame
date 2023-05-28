package Game;

public class GameMenu {
    private GameEngine gameEngine;

    public GameMenu(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }

    public GameEngine getGameEngine() {
        return gameEngine;
    }

    public void setGameEngine(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
    }
}
