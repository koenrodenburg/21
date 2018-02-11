package model;

import java.util.function.Function;

/**
 * Action that a player can take in a Game
 */
public enum Action {
    HIT(Game::hit),
    STAND(Game::stand);

    private final Function<Game, Game> action;

    /**
     * Constructor
     * @param action Function The Function that should be executed in the Game when the player takes this action
     */
    Action(Function<Game, Game> action) {
        this.action = action;
    }

    /**
     * Executue this action in the context of the game
     * @param game Game the Game to play this Action in
     * @return Game the updated Game
     */
    public Game execute(Game game) {
        return action.apply(game);
    }
}
