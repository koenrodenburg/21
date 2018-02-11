package controller;

import model.Action;
import model.Game;
import org.springframework.web.bind.annotation.*;
import view.GameBean;

/**
 * Controller for the Game API
 */
@RestController
@RequestMapping("game")
public class GameController {

    /**
     * Start a game by hitting the endpoint with a GET request
     * @return GameBean Representation of the current state of the Game
     */
    @RequestMapping(path = "/", method = RequestMethod.GET)
    public GameBean getGameState() {
        return new GameBean(Game.newGame());
    }

    /**
     * Play the game by hitting the endpoint with a POST request containing the chosen action
     * @param action String The action to perform
     * @return GameBean Representation of the current state of the Game
     */
    @RequestMapping(path = "/", method = RequestMethod.POST)
    public GameBean updateGame(@RequestParam("action") Action action) {
        Game game = Game.getCurrentGame();
        action.execute(game);
        return new GameBean(game);
    }
}
