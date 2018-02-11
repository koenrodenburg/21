package model;

import model.cards.Deck;
import model.cards.Hand;

import java.util.function.Function;

/**
 * Class representing the game
 */
public class Game {
    private static final int MAXIMUM_POINTS = 21;
    private static final int BANK_MINIMUM_POINTS = 17;

    /**
     * Singleton pattern for Game, with static getInstance and private constructor
     */
    private static final Game INSTANCE = new Game();
    public static Game getInstance() {
        return INSTANCE;
    }

    private final Deck deck;
    private final Hand bank;
    private final Hand player;
    private Status status;

    private Game() {
        // Initialize the deck and hands
        deck = new Deck().shuffle();
        player = new Hand();
        bank = new Hand();

        // Deal the first cards
        player.giveCard(deck.deal());
        bank.giveCard(deck.deal());

        // TODO place bets

        // The player gets a second card and starts his turn
        player.giveCard(deck.deal());
        status = Status.PLAYERS_TURN;
    }

    public Hand getBank() {
        return bank;
    }

    public Hand getPlayer() {
        return player;
    }

    public Status getStatus() {
        return status;
    }

    public Game hit() {
        return update(() -> player.giveCard(deck.deal()));
    }

    public Game stand() {
        return update(() -> status = Status.BANKS_TURN);
    }

    private Game update(Runnable action) {
        assertActiveGame();
        action.run();
        afterUpdate();
        return this;
    }

    private void assertActiveGame() {
        if(status != Status.PLAYERS_TURN) {
            throw new UnsupportedOperationException("This action is not allowed because it is not the player's turn.");
        }
    }

    private void afterUpdate() {
        if(status == Status.PLAYERS_TURN && player.getValue() > MAXIMUM_POINTS) {
            // If the player's hand exceeds the maximum number of points, he loses and the bank wins
            status = Status.BANK_WINS;
        } else if(status == Status.BANKS_TURN) {
            playBank();
            setOutcome();
        }
    }

    private void playBank() {
        while(bank.getValue() < BANK_MINIMUM_POINTS) {
            bank.giveCard(deck.deal());
        }
    }

    private void setOutcome() {
        if(bank.getValue() > MAXIMUM_POINTS || bank.getValue() < player.getValue()) {
            status = Status.PLAYER_WINS;
        } else {
            status = Status.BANK_WINS;
        }
    }

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

    public enum Status {
        PLAYERS_TURN,
        BANKS_TURN,
        PLAYER_WINS,
        BANK_WINS
    }
}
