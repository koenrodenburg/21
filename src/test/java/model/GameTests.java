package model;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Test class for Game
 */
@RunWith(SpringRunner.class)
public class GameTests {
    private Game game;

    /**
     * Start a new game before each test
     */
    @Before
    public void setup() {
        game = Game.newGame();
    }

    /**
     * Assert that the game is initialized correctly
     */
    @Test
    public void init() {
        assertThat(game.getGameStatus()).isEqualTo(GameStatus.PLAYERS_TURN);
        assertThat(game.getBank().getNumberOfCards()).isEqualTo(1);
        assertThat(game.getPlayer().getNumberOfCards()).isEqualTo(2);
    }

    /**
     * Assert that the bank wins if the player keeps 'hit'ing
     */
    @Test
    public void throwGameHit() {
        while(game.getGameStatus() == GameStatus.PLAYERS_TURN) {
            game.hit();
        }
        assertThat(game.getGameStatus() == GameStatus.BANK_WINS);
    }
}
