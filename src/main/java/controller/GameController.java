package controller;

import model.Action;
import model.Game;
import org.springframework.web.bind.annotation.*;
import view.GameBean;

/**
 * Controller for the REST API
 */
@RestController
@RequestMapping("game")
public class GameController {

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public GameBean getGameState() {
        return new GameBean(Game.getCurrentGame());
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public GameBean updateGame(@RequestParam("action") Action action) {
        Game game = Game.getCurrentGame();
        action.execute(game);
        return new GameBean(game);
    }
}
