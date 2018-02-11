package model;

import java.util.function.Function;

/**
 * Created by Koen Rodenburg on 11-2-2018.
 */
public enum Action {
    HIT(Game::hit),
    STAND(Game::stand);

    private final Function<Game, Game> action;

    Action(Function<Game, Game> action) {
        this.action = action;
    }

    public Game execute(Game game) {
        return action.apply(game);
    }
}
