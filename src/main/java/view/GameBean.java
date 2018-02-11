package view;

import model.Game;

/**
 * Bean representing the current state of the game
 */
public class GameBean {
    private final String status;
    private final HandBean player;
    private final HandBean bank;

    public GameBean(Game game) {
        status = game.getGameStatus().toString();
        player = new HandBean(game.getPlayer());
        bank = new HandBean(game.getBank());
    }

    public String getStatus() {
        return status;
    }

    public HandBean getPlayer() {
        return player;
    }

    public HandBean getBank() {
        return bank;
    }
}
